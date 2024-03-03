package com.cadastrorh.cadastroRHapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {
    @GetMapping
    public static String sayHello() {return "Cadastro de Dados para RH - Success!!!";}
}
