package com.cadastrorh.cadastroRHapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {
    @GetMapping
    public static String sayHello() {return "Inserir os dados do candidato!!!";}
}
