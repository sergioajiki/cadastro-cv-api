package com.cadastrorh.cadastroRHapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "candidatos")
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private LocalDate dataNascimento;
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
    private String curriculum;
    private String observacao;
    @OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL)
    private List<Experiencia> experieciaList;
    @OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL)
    private List<Ensino> ensinoList;
}
