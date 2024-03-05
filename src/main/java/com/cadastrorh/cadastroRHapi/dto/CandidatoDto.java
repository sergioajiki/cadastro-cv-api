package com.cadastrorh.cadastroRHapi.dto;

import com.cadastrorh.cadastroRHapi.entity.Candidato;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record CandidatoDto(
        Long id,
        @NotBlank(message = "Field nome can not be null or empty")
        String nome,
        @NotBlank(message = "Field sobrenome can not be null or empty")
        String sobrenome,
        @NotBlank(message = "Field cpf can not be null or empty")
        String cpf,
        @NotBlank(message = "Field dataNascimento can not be null or empty")
        LocalDate dataNascimento,
        @NotBlank(message = "Field genero can not be null or empty")
        String genero,
        @NotBlank(message = "Field estadoCivil can not be null or empty")
        String estadoCivil,
        @NotBlank(message = "Field pcd can not be null or empty")
        Boolean pcd,
        @NotBlank(message = "Field dataNascimento can not be null or empty")
        String naturalidade,
        @NotBlank(message = "Field telCandidato can not be null or empty")
        String telCandidato,
        @NotBlank(message = "Field email can not be null or empty")
        String email,
        @NotBlank(message = "Field cep can not be null or empty")
        String cep,
        @NotBlank(message = "Field estado can not be null or empty")
        String estado,
        @NotBlank(message = "Field cidade can not be null or empty")
        String cidade,
        String bairro,
        @NotBlank(message = "Field endereco can not be null or empty")
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
        String observacao
) {
    public static CandidatoDto candidatoToCandidatoDto(Candidato candidato) {
        return new CandidatoDto(
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
                candidato.getObservacao()
        );
    }

    public static Candidato CandidatoDtoToCandidato(CandidatoDto candidatoDto) {
            Candidato candidato = new Candidato();
            candidato.setId(candidatoDto.id);
            candidato.setNome(candidatoDto.nome);
            candidato.setSobrenome(candidatoDto.sobrenome);
            candidato.setCpf(candidatoDto.cpf);
            candidato.setDataNascimento(candidatoDto.dataNascimento);
            candidato.setGenero(candidatoDto.genero);
            candidato.setEstadoCivil(candidatoDto.estadoCivil);
            candidato.setPcd(candidatoDto.pcd);
            candidato.setNaturalidade(candidatoDto.naturalidade);
            candidato.setTelCandidato(candidatoDto.telCandidato);
            candidato.setEmail(candidatoDto.email);
            candidato.setCep(candidatoDto.cep);
            candidato.setEstado(candidatoDto.estado);
            candidato.setCidade(candidatoDto.cidade);
            candidato.setBairro(candidatoDto.bairro);
            candidato.setEndereco(candidatoDto.endereco);
            candidato.setNumero(candidatoDto.numero);
            candidato.setComplemento(candidatoDto.complemento);
            candidato.setContatoA(candidatoDto.contatoA);
            candidato.setTelContatoA(candidatoDto.telContatoA);
            candidato.setContatoB(candidatoDto.contatoB);
            candidato.setTelCandidato(candidatoDto.telContatoB);
            candidato.setFoto(candidatoDto.foto);
            candidato.setPretensaoSalarial(candidatoDto.pretensaoSalarial);
            candidato.setPossuiEmprego(candidatoDto.possuiEmprego);
            candidato.setCargoPretendido(candidatoDto.cargoPretendido);
            candidato.setTempoExperiencia(candidatoDto.tempoExperiencia);
            candidato.setPossuiCnh(candidatoDto.possuiCnh);
            candidato.setCategoriaCnh(candidatoDto.categoriaCnh);
            candidato.setPossuiVeiculo(candidatoDto.possuiVeiculo);
            candidato.setAlturaCandidato(candidatoDto.alturaCandidato);
            candidato.setPesoCandidato(candidatoDto.pesoCandidato);
            candidato.setPossuiFilhos(candidatoDto.possuiFilhos);
            candidato.setIdadeFilhos(candidatoDto.idadeFilhos);
            candidato.setCurriculum(candidatoDto.curriculum);
            candidato.setObservacao(candidatoDto.observacao);

            return candidato;
    }
}
