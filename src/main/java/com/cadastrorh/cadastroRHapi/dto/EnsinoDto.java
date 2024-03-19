package com.cadastrorh.cadastroRHapi.dto;

import com.cadastrorh.cadastroRHapi.entity.Candidato;
import com.cadastrorh.cadastroRHapi.entity.Ensino;

import java.time.LocalDate;

public record EnsinoDto(
        String cpfCandidato,
        String nomeCurso,
        String nomeEscola,
        String cidadeEscola,
        LocalDate dataConclusao,
        Long cargaHoraria
) {
    public static EnsinoDto ensinoToEnsinoDto(Ensino ensino) {
        return new EnsinoDto(
                ensino.getCandidato().getCpf(),
                ensino.getNomeCurso(),
                ensino.getNomeEscola(),
                ensino.getCidadeEscola(),
                ensino.getDataConclusao(),
                ensino.getCargaHoraria()
        );
    }

    public static Ensino ensinoDtoToEnsino(EnsinoDto ensinoDto) {
        Ensino ensino = new Ensino();
        Candidato candidato = new Candidato();
        candidato.setCpf(ensinoDto.cpfCandidato);
        ensino.setNomeCurso(ensinoDto.nomeCurso);
        ensino.setNomeEscola(ensinoDto.nomeEscola);
        ensino.setCidadeEscola(ensinoDto.cidadeEscola);
        ensino.setDataConclusao(ensinoDto.dataConclusao);
        ensino.setCargaHoraria(ensinoDto.cargaHoraria);

        return ensino;
    }
}
