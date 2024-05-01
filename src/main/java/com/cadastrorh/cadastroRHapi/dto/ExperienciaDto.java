package com.cadastrorh.cadastroRHapi.dto;

import com.cadastrorh.cadastroRHapi.entity.Candidato;
import com.cadastrorh.cadastroRHapi.entity.Experiencia;

public record ExperienciaDto(
        String empresa,
        String cargoAnterior,
        String contatoEmpresa
) {
    public static ExperienciaDto experienciaToExperienciaDto(Experiencia experiencia) {
        return new ExperienciaDto(
                experiencia.getEmpresa(),
                experiencia.getCargoAnterior(),
                experiencia.getContatoEmpresa()
        );
    }

    public static Experiencia experienciaDtoToExperiencia(ExperienciaDto experienciaDto) {
        Experiencia experiencia = new Experiencia();
        experiencia.setEmpresa(experienciaDto.empresa);
        experiencia.setCargoAnterior(experienciaDto.cargoAnterior);
        experiencia.setContatoEmpresa(experienciaDto.contatoEmpresa);
        return experiencia;
    }
}
