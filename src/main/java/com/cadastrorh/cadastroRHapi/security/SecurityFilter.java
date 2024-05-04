package com.cadastrorh.cadastroRHapi.security;

import com.cadastrorh.cadastroRHapi.advice.Problem;
import com.cadastrorh.cadastroRHapi.service.AdminService;
import com.cadastrorh.cadastroRHapi.service.TokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

public class SecurityFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final AdminService adminService;
    private final ObjectMapper objectMapper;

    @Autowired
    public SecurityFilter(TokenService tokenService, AdminService adminService, ObjectMapper objectMapper) {
        this.tokenService = tokenService;
        this.adminService = adminService;
        this.objectMapper = objectMapper;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        Optional<String> token = extractToken(request);
        String subject = tokenService.validateToken(token.get());
        UserDetails userDetails = adminService.loadUserByUsername(subject);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
        return;
    }

    private Optional<String> extractToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
            authHeader = authHeader.replace("Bearer ", "");
        }
        return Optional.ofNullable(authHeader);
    }

    private void catchJWTError(HttpServletResponse response, String title, String detail)
            throws IOException {
        Problem problem = new Problem(
                HttpStatus.FORBIDDEN.value(),
                "Token expired or invalid",
                detail,
                null
        );
        String json = objectMapper.writeValueAsString(problem);
        response.setContentType("application/json; charset=UTF-8");
        response.getWriter().write(json);
        response.getWriter().flush();
        response.getWriter().close();
    }
}
