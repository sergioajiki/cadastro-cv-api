package com.cadastrorh.cadastroRHapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "experiencias")
public class Experiencia {
    private Long idExperiencia;
    private Long idCandidato;
    private String empresa;
    private String cargoAnterior;
    private String contatoEmpresa;
}
