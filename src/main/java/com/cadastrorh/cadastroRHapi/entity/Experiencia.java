package com.cadastrorh.cadastroRHapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "experiencias")
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExperiencia;
    private Long idCandidato;
    private String empresa;
    private String cargoAnterior;
    private String contatoEmpresa;
    @ManyToOne
    @JoinColumn(name = "id")
    private Candidato candidato;
}
