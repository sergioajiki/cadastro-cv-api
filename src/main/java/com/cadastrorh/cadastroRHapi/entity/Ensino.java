package com.cadastrorh.cadastroRHapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "ensinos")
public class Ensino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEscola;
    private String cpfCandidato;
    private String nomeCurso;
    private String nomeEscola;
    private String cidadeEscola;
    private LocalDate dataConclusao;
    private Long cargaHoraria;

    @ManyToOne
    @JoinColumn(name = "cpf_candidato_fk", referencedColumnName = "cpf")
    private Candidato candidato;
}
