package com.cadastrorh.cadastroRHapi.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String codeSecret;

    public String generateToken(String email) {
        Algorithm algorithm = Algorithm.HMAC256(codeSecret);
        return JWT.create()
                .withSubject(email)
                .withExpiresAt(generateExpirationDate())
                .sign(algorithm);
    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }

    public String validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(codeSecret);
        return JWT.require(algorithm)
                .build()
                .verify(token)
                .getSubject();
    }

    private SecurityScheme createApiKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                .components(new Components().addSecuritySchemes("Bearer Authentication", createApiKeyScheme()))
                .info(new Info().title("My Api CadastroRH")
                        .description("API cadastro de RH")
                        .version("1.0")
                        .contact(new Contact().name("Sergio"))
                );
    }
}
