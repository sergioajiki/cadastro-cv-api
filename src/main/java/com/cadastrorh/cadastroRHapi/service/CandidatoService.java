package com.cadastrorh.cadastroRHapi.service;

import com.cadastrorh.cadastroRHapi.dto.CandidatoDto;
import com.cadastrorh.cadastroRHapi.entity.Candidato;
import com.cadastrorh.cadastroRHapi.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

//    public List<infoCandidatoDto> getAllCandidatos() {
//        List<Candidato> listCandidato = candidatoRepository.findAll();
//        List<infoCandidatoDto> fullList = new ArrayList<>();
//        listCandidato.forEach(candidato -> {
//            candidato.getId(),
//
//        })
//    }
}
