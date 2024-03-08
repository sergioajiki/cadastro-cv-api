package com.cadastrorh.cadastroRHapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private Date dataConclusao;
    private Long cargaHoraria;
    @ManyToOne
    @JoinColumn(name = "cpf")
    private Candidato candidato;
}
