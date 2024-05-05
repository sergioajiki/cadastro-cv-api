package com.cadastrorh.cadastroRHapi.controller;

import com.cadastrorh.cadastroRHapi.dto.CandidatoDto;
import com.cadastrorh.cadastroRHapi.dto.EnsinoDto;
import com.cadastrorh.cadastroRHapi.dto.ExperienciaDto;
import com.cadastrorh.cadastroRHapi.dto.InfoCandidatoDto;
import com.cadastrorh.cadastroRHapi.service.CandidatoService;
import com.cadastrorh.cadastroRHapi.service.EnsinoService;
import com.cadastrorh.cadastroRHapi.service.ExperienciaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
    private final ExperienciaService experienciaService;

    public CandidatoController(CandidatoService candidatoService, EnsinoService ensinoService, ExperienciaService experienciaService) {
        this.candidatoService = candidatoService;
        this.ensinoService = ensinoService;
        this.experienciaService = experienciaService;
    }

    @GetMapping("/all")
    @Operation(description = "Lista todos os candidatos")
    public ResponseEntity<List<InfoCandidatoDto>> getAllCandidatos() {
        List<InfoCandidatoDto> allCandidatos = candidatoService.getAllCandidatos();

        return ResponseEntity.status(HttpStatus.OK).body(allCandidatos);
    }

    @GetMapping("/nome/{nome}")
    @Operation(description = "Lista de candidatos por nome")
    public ResponseEntity<List<InfoCandidatoDto>> getCandidatosByNome(@RequestParam String nome) {
        List<InfoCandidatoDto> candidatosByNome = candidatoService.getCandidatosByNome(nome);

        return ResponseEntity.status(HttpStatus.OK).body(candidatosByNome);
    }
    @PostMapping
    @Operation(description = "Cadastrar dados do candidato")
    public ResponseEntity<CandidatoDto> registerCandidato(@RequestBody @Valid CandidatoDto candidatoDto) {
        CandidatoDto candidatoRegistrado = candidatoService.registerCandidato(candidatoDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(candidatoRegistrado);
    }

    @PostMapping("/ensino/{cpf}")
    @Operation(description = "Cadastrar ensino")
    public ResponseEntity<EnsinoDto> registerEnsino(@RequestBody EnsinoDto ensinoDto, @RequestParam String cpf) throws Exception {
        EnsinoDto ensinoRegistrado = ensinoService.registerEnsino(ensinoDto, cpf );

        return ResponseEntity.status(HttpStatus.CREATED).body(ensinoRegistrado);
    }

    @PostMapping("/experiencia/{cpf}")
    @Operation(description = "Cadastrar experiência")
    public ResponseEntity<ExperienciaDto> registerExperiencia(@RequestBody ExperienciaDto experienciaDto, @RequestParam String cpf) throws Exception {
        ExperienciaDto experienciaRegistrada = experienciaService.registerExperiencia(experienciaDto, cpf);

        return ResponseEntity.status(HttpStatus.CREATED).body(experienciaRegistrada);
    }

}

