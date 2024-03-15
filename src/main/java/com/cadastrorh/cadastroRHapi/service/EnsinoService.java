package com.cadastrorh.cadastroRHapi.service;

import com.cadastrorh.cadastroRHapi.dto.EnsinoDto;
import com.cadastrorh.cadastroRHapi.entity.Ensino;
import com.cadastrorh.cadastroRHapi.repository.EnsinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnsinoService {
    private final EnsinoRepository ensinoRepository;

    @Autowired
    public EnsinoService(EnsinoRepository ensinoRepository) {
        this.ensinoRepository = ensinoRepository;
    }

    public EnsinoDto registerEnsino(EnsinoDto ensinoDto) {
        Ensino ensinoToSave = EnsinoDto.ensinoDtoToEnsino(ensinoDto);

        ensinoRepository.save(ensinoToSave);

        EnsinoDto savedEnsino = EnsinoDto.ensinoToEnsinoDto(ensinoToSave);

        return savedEnsino;
    }
}
