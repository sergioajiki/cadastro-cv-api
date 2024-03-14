package com.cadastrorh.cadastroRHapi.controller;

import com.cadastrorh.cadastroRHapi.dto.CandidatoDto;
import com.cadastrorh.cadastroRHapi.dto.EnsinoDto;
import com.cadastrorh.cadastroRHapi.dto.InfoCandidatoDto;
import com.cadastrorh.cadastroRHapi.service.CandidatoService;
import com.cadastrorh.cadastroRHapi.service.EnsinoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Candidatos")
@RequestMapping("/candidato")
public class CandidatoController {
    private final CandidatoService candidatoService;
    private final EnsinoService ensinoService;

    public CandidatoController(CandidatoService candidatoService, EnsinoService ensinoService) {
        this.candidatoService = candidatoService;
        this.ensinoService = ensinoService;
    }

    @PostMapping
    @Operation(description = "Cadastrar dados do candidato")
    public ResponseEntity<CandidatoDto> registerCandidato(@RequestBody CandidatoDto candidatoDto) {
        CandidatoDto candidatoRegistrado = candidatoService.registerCandidato(candidatoDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(candidatoRegistrado);
    }

    @GetMapping
    @Operation(description = "Lista de candidatos")
    public ResponseEntity<List<InfoCandidatoDto>> getAllCandidatos() {
        List<InfoCandidatoDto> allCandidatos = candidatoService.getAllCandidatos();
        return ResponseEntity.status(HttpStatus.OK).body(allCandidatos);
    }

    @PostMapping("/ensino")
    @Operation(description = "Cadastrar ensino")
    public ResponseEntity<EnsinoDto> registerEnsino(@RequestBody EnsinoDto ensinoDto) {
        EnsinoDto ensinoRegistrado = ensinoService.registerEnsino(ensinoDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(ensinoRegistrado);
    }
}

