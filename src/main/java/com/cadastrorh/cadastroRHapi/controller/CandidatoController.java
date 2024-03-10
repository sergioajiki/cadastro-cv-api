package com.cadastrorh.cadastroRHapi.controller;

import com.cadastrorh.cadastroRHapi.dto.CandidatoDto;
import com.cadastrorh.cadastroRHapi.service.CandidatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {
    private final CandidatoService candidatoService;

    public CandidatoController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService;
    }

    @GetMapping
    public String sayHello() {return "Inserir os dados do candidato!!!";}

    @PostMapping
    public ResponseEntity<CandidatoDto> registerCandidato(@RequestBody CandidatoDto candidatoDto) {
        CandidatoDto candidatoRegistrado = candidatoService.registerCandidato(candidatoDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(candidatoRegistrado);
    }

}
