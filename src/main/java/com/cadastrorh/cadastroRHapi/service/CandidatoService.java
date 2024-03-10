package com.cadastrorh.cadastroRHapi.service;

import com.cadastrorh.cadastroRHapi.dto.CandidatoDto;
import com.cadastrorh.cadastroRHapi.entity.Candidato;
import com.cadastrorh.cadastroRHapi.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatoService {
    private final CandidatoRepository candidatoRepository;

    @Autowired
    public CandidatoService(CandidatoRepository candidatoRepository) {
        this.candidatoRepository = candidatoRepository;
    }

    public CandidatoDto registerCandidato(CandidatoDto candidatoDto) {
        Candidato candidatoToSave = CandidatoDto.candidatoDtoToCandidato(candidatoDto);

        candidatoRepository.save(candidatoToSave);
        CandidatoDto savedCandidato = CandidatoDto.candidatoToCandidatoDto(candidatoToSave);
        return savedCandidato;
    }
}
