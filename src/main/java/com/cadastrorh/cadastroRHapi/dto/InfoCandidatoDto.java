package com.cadastrorh.cadastroRHapi.dto;

import com.cadastrorh.cadastroRHapi.entity.Candidato;
import com.cadastrorh.cadastroRHapi.entity.Ensino;
import com.cadastrorh.cadastroRHapi.entity.Experiencia;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record InfoCandidatoDto(
        Long id,
        String nome,
        String sobrenome,
        String cpf,
//        String password,
        LocalDate dataNascimento,
        String genero,
        String estadoCivil,
        Boolean pcd,
        String naturalidade,
        String telCandidato,
        String email,
        String cep,
        String estado,
        String cidade,
        String bairro,
        String endereco,
        Integer numero,
        String complemento,
        String contatoA,
        String telContatoA,
        String contatoB,
        String telContatoB,
        String foto,
        Integer pretensaoSalarial,
        Boolean possuiEmprego,
        String cargoPretendido,
        String tempoExperiencia,
        Boolean possuiCnh,
        String categoriaCnh,
        Boolean possuiVeiculo,
        Double alturaCandidato,
        Double pesoCandidato,
        Boolean possuiFilhos,
        String idadeFilhos,
        String curriculum,
        String observacao,
        List<ExperienciaDto> experienciaList,
        List<EnsinoDto> ensinoList

) {
    public static InfoCandidatoDto infoCandidatoToInfoCandidatoDto(Candidato candidato) {
        List<Ensino> ensinoList = candidato.getEnsinoList();
//        System.out.println(ensinoList);
        List<EnsinoDto> ensinoDtoList = ensinoList.stream()
                .map(EnsinoDto::ensinoToEnsinoDto)
                .collect(Collectors.toList());
        List<Experiencia> experienciaList = candidato.getExperieciaList();
        List<ExperienciaDto> experienciaDtoList = experienciaList.stream()
                .map(ExperienciaDto::experienciaToExperienciaDto)
                .toList();
        return new InfoCandidatoDto(
                candidato.getId(),
                candidato.getNome(),
                candidato.getSobrenome(),
                candidato.getCpf(),
                candidato.getDataNascimento(),
                candidato.getGenero(),
                candidato.getEstadoCivil(),
                candidato.getPcd(),
                candidato.getNaturalidade(),
                candidato.getTelCandidato(),
                candidato.getEmail(),
                candidato.getCep(),
                candidato.getEstado(),
                candidato.getCidade(),
                candidato.getBairro(),
                candidato.getEndereco(),
                candidato.getNumero(),
                candidato.getComplemento(),
                candidato.getContatoA(),
                candidato.getTelContatoA(),
                candidato.getContatoB(),
                candidato.getTelContatoB(),
                candidato.getFoto(),
                candidato.getPretensaoSalarial(),
                candidato.getPossuiEmprego(),
                candidato.getCargoPretendido(),
                candidato.getTempoExperiencia(),
                candidato.getPossuiCnh(),
                candidato.getCategoriaCnh(),
                candidato.getPossuiVeiculo(),
                candidato.getAlturaCandidato(),
                candidato.getPesoCandidato(),
                candidato.getPossuiFilhos(),
                candidato.getIdadeFilhos(),
                candidato.getCurriculum(),
                candidato.getObservacao(),
                experienciaDtoList,
                ensinoDtoList
        );
    }
}
