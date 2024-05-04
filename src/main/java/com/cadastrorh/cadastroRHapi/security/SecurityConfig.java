package com.cadastrorh.cadastroRHapi.security;

import com.cadastrorh.cadastroRHapi.service.AdminService;
import com.cadastrorh.cadastroRHapi.service.TokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    private final AdminService adminService;
    private final TokenService tokenService;
    private final ObjectMapper objectMapper;
    private final HandlerExceptionResolver handlerExceptionResolver;


    public SecurityConfig(AdminService adminService) {
        this.adminService = adminService;
    }
}
