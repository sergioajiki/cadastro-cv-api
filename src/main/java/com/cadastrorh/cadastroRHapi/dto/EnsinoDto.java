package com.cadastrorh.cadastroRHapi.dto;

import com.cadastrorh.cadastroRHapi.entity.Ensino;

import java.time.LocalDate;

public record EnsinoDto(
//        String cpfCandidato
        String nomeCurso,
        String nomeEscola,
        String cidadeEscola,
        LocalDate dataConclusao,
        Long cargaHoraria
) {
    public static EnsinoDto ensinoToEnsinoDto(Ensino ensino) {
        return new EnsinoDto(
//                ensino.getCpfCandidato(),
                ensino.getNomeCurso(),
                ensino.getNomeEscola(),
                ensino.getCidadeEscola(),
                ensino.getDataConclusao(),
                ensino.getCargaHoraria()
        );
    }

    public static Ensino ensinoDtoToEnsino(EnsinoDto ensinoDto) {
        Ensino ensino = new Ensino();
//        ensino.setCpfCandidato(ensinoDto.cpfCandidato);
        ensino.setNomeCurso(ensinoDto.nomeCurso);
        ensino.setNomeEscola(ensinoDto.nomeEscola);
        ensino.setCidadeEscola(ensinoDto.cidadeEscola);
        ensino.setDataConclusao(ensinoDto.dataConclusao);
        ensino.setCargaHoraria(ensinoDto.cargaHoraria);

        return ensino;
    }
}
