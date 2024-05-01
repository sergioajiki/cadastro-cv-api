package com.cadastrorh.cadastroRHapi.service;

import com.cadastrorh.cadastroRHapi.dto.EnsinoDto;
import com.cadastrorh.cadastroRHapi.entity.Candidato;
import com.cadastrorh.cadastroRHapi.entity.Ensino;
import com.cadastrorh.cadastroRHapi.exception.NotFoundException;
import com.cadastrorh.cadastroRHapi.repository.CandidatoRepository;
import com.cadastrorh.cadastroRHapi.repository.EnsinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnsinoService {
    private final EnsinoRepository ensinoRepository;
    private final CandidatoRepository candidatoRepository;

    @Autowired
    public EnsinoService(EnsinoRepository ensinoRepository, CandidatoRepository candidatoRepository) {
        this.ensinoRepository = ensinoRepository;
        this.candidatoRepository = candidatoRepository;
    }

    public EnsinoDto registerEnsino(EnsinoDto ensinoDto, String cpf) {
        Ensino ensinoToSave = EnsinoDto.ensinoDtoToEnsino(ensinoDto);
        Optional<Candidato> candidatoOptional = Optional.ofNullable(candidatoRepository.findByCpf(cpf));
        if (candidatoOptional.isEmpty()) {
            throw new NotFoundException("CPF " + cpf + " not found");
        }
        Candidato candidato = candidatoOptional.get();
        ensinoToSave.setCandidato(candidato);

        ensinoRepository.save(ensinoToSave);
        EnsinoDto savedEnsino = EnsinoDto.ensinoToEnsinoDto(ensinoToSave);

        return savedEnsino;
    }
}
