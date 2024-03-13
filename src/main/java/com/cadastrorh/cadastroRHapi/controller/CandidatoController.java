package com.cadastrorh.cadastroRHapi.controller;

import com.cadastrorh.cadastroRHapi.dto.CandidatoDto;
import com.cadastrorh.cadastroRHapi.service.CandidatoService;
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

    public CandidatoController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService;
    }

    @GetMapping
    @Operation(description = "Aguardando implementação do get!!")
    public String sayHello() {return "Inserir os dados do candidato!!!";}

    @PostMapping
    @Operation(description = "Cadastrar dados do candidato")
    public ResponseEntity<CandidatoDto> registerCandidato(@RequestBody CandidatoDto candidatoDto) {
        CandidatoDto candidatoRegistrado = candidatoService.registerCandidato(candidatoDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(candidatoRegistrado);
    }

    @GetMapping
    @Operation(description = "List de candidatos")
    public ResponseEntity<List<CandidatoDto>> getAllCandidatos(){
        List<CandidatoDto> allCandidatos = candidatoService.getAllCAndidatos();
        return ResponseEntity.status(HttpStatus.OK).body(allCandidatos);
    }

}
