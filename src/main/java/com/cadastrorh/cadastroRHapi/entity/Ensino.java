package com.cadastrorh.cadastroRHapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ensinos")
public class Ensino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEscola;

    private String nomeCurso;
    private String nomeEscola;
    private String cidadeEscola;
    private LocalDate dataConclusao;
    private Long cargaHoraria;

    @ManyToOne
    @JoinColumn(name = "candidato_id", referencedColumnName = "id")
    private Candidato candidato;
}
