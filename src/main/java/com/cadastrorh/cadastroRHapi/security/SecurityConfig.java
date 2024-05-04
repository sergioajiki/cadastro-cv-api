package com.cadastrorh.cadastroRHapi.security;

import com.cadastrorh.cadastroRHapi.service.AdminService;
import com.cadastrorh.cadastroRHapi.service.TokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    private final AdminService adminService;
    private final TokenService tokenService;
    private final ObjectMapper objectMapper;
    private final HandlerExceptionResolver handlerExceptionResolver;
    private final CustomBasicAuthenticationEntryPoint customBasicAuthenticationEntryPoint;

    public SecurityConfig(
            AdminService adminService,
            TokenService tokenService,
            ObjectMapper objectMapper,
            HandlerExceptionResolver handlerExceptionResolver,
            CustomBasicAuthenticationEntryPoint customBasicAuthenticationEntryPoint) {
        this.adminService = adminService;
        this.tokenService = tokenService;
        this.objectMapper = objectMapper;
        this.handlerExceptionResolver = handlerExceptionResolver;
        this.customBasicAuthenticationEntryPoint = customBasicAuthenticationEntryPoint;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
            throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(
                        authorize -> authorize
                                .requestMatchers(HttpMethod.POST, "/admin/login").permitAll()
                                .requestMatchers(HttpMethod.POST, "/admin/cadastro").permitAll()
                                .requestMatchers(HttpMethod.POST, "/candidato").permitAll()
                                .requestMatchers(HttpMethod.POST, "/ensino/{cpf}").permitAll()
                                .requestMatchers(HttpMethod.POST, "/experiencia/{cpf}").permitAll()
                                .requestMatchers("/health").permitAll()
                                .requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll()
                                .anyRequest().authenticated()
                )
                .httpBasic((httpBasic -> httpBasic.authenticationEntryPoint(customBasicAuthenticationEntryPoint)))
                .addFilterBefore(
                        new CustomFilter(adminService, tokenService, handlerExceptionResolver, objectMapper),
                        UsernamePasswordAuthenticationFilter.class
                )
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
