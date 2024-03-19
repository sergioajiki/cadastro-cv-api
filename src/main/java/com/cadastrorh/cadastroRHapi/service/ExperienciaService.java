package com.cadastrorh.cadastroRHapi.service;

import com.cadastrorh.cadastroRHapi.dto.ExperienciaDto;
import com.cadastrorh.cadastroRHapi.entity.Experiencia;
import com.cadastrorh.cadastroRHapi.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService {
    private final ExperienciaRepository experienciaRepository;

    @Autowired
    public ExperienciaService(ExperienciaRepository experienciaRepository) {
        this.experienciaRepository = experienciaRepository;
    }

    public ExperienciaDto registerExperiencia(ExperienciaDto experienciaDto) {
        Experiencia experienciaToSave = ExperienciaDto.experienciaDtoToExperiencia(experienciaDto);

        experienciaRepository.save(experienciaToSave);

        ExperienciaDto savedExperiencia = ExperienciaDto.experienciaToExperienciaDto(experienciaToSave);

        return savedExperiencia;
    }
}
