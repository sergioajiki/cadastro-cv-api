package com.cadastrorh.cadastroRHapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "candidatos")
public class Candidato {
    private Integer id;
    private String name;
    private String sobrenome;
    private String cpf;
    private String dataNascimento;
    private String genero;
    private String estadoCivil;
    private Boolean pcd;
    private String naturalidade;
    private String telCandidato;
    private String email;
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String endereco;
    private Integer numero;
    private String complemento;
    private String contatoA;
    private String telContatoA;
    private String contatoB;
    private String telContatoB;
    private String foto;
    private Integer pretensaoSalarial;
    private Boolean possuiEmprego;
    private String cargoPretendido;
    private String tempoExperiencia;
    private Boolean possuiCnh;
    private String categoriaCnh;
    private Boolean possuiVeiculo;
    private Double alturaCandidato;
    private Double pesoCandidato;
    private Boolean possuiFilhos;
    private String idadeFilhos;

}
