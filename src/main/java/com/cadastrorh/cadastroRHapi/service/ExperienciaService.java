package com.cadastrorh.cadastroRHapi.service;

import com.cadastrorh.cadastroRHapi.dto.ExperienciaDto;
import com.cadastrorh.cadastroRHapi.entity.Candidato;
import com.cadastrorh.cadastroRHapi.entity.Experiencia;
import com.cadastrorh.cadastroRHapi.exception.NotFoundException;
import com.cadastrorh.cadastroRHapi.repository.CandidatoRepository;
import com.cadastrorh.cadastroRHapi.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExperienciaService {
    private final ExperienciaRepository experienciaRepository;
    private final CandidatoRepository candidatoRepository;

    @Autowired
    public ExperienciaService(ExperienciaRepository experienciaRepository, CandidatoRepository candidatoRepository) {
        this.experienciaRepository = experienciaRepository;
        this.candidatoRepository = candidatoRepository;
    }

    public ExperienciaDto registerExperiencia(ExperienciaDto experienciaDto, String cpf) {
        Experiencia experienciaToSave = ExperienciaDto.experienciaDtoToExperiencia(experienciaDto);
        Optional<Candidato> candidatoOptional = Optional.ofNullable(candidatoRepository.findByCpf(cpf));
        if (candidatoOptional.isEmpty()) {
            throw new NotFoundException("CPF " + cpf + " not found");
        }
        Candidato candidato = candidatoOptional.get();
        experienciaToSave.setCandidato(candidato);

        experienciaRepository.save(experienciaToSave);
        ExperienciaDto savedExperiencia = ExperienciaDto.experienciaToExperienciaDto(experienciaToSave);

        return savedExperiencia;
    }
}
