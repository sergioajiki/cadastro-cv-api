package com.cadastrorh.cadastroRHapi.service;

import com.cadastrorh.cadastroRHapi.dto.CandidatoDto;
import com.cadastrorh.cadastroRHapi.dto.EnsinoDto;
import com.cadastrorh.cadastroRHapi.dto.ExperienciaDto;
import com.cadastrorh.cadastroRHapi.dto.InfoCandidatoDto;
import com.cadastrorh.cadastroRHapi.entity.Candidato;
import com.cadastrorh.cadastroRHapi.entity.Ensino;
import com.cadastrorh.cadastroRHapi.entity.Experiencia;
import com.cadastrorh.cadastroRHapi.exception.DuplicateEntryException;
import com.cadastrorh.cadastroRHapi.exception.InvalidEmailFormatException;
import com.cadastrorh.cadastroRHapi.repository.CandidatoRepository;
import com.cadastrorh.cadastroRHapi.repository.EnsinoRepository;
import com.cadastrorh.cadastroRHapi.util.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidatoService {
    private final CandidatoRepository candidatoRepository;
    private final EnsinoRepository ensinoRepository;

    @Autowired
    public CandidatoService(CandidatoRepository candidatoRepository, EnsinoRepository ensinoRepository) {
        this.candidatoRepository = candidatoRepository;
        this.ensinoRepository = ensinoRepository;
    }

    public CandidatoDto registerCandidato(CandidatoDto candidatoDto) {
        Candidato candidatoToSave = CandidatoDto.candidatoDtoToCandidato(candidatoDto);

        boolean isEmail = EmailValidator.isValidEmail(candidatoToSave.getEmail());
        if(!isEmail) {
            throw new InvalidEmailFormatException("Invalid email format");
        }

        Optional<Candidato> verifyCpfCandidatoOptional = Optional.ofNullable(candidatoRepository.findByCpf(candidatoToSave.getCpf()));
        if(verifyCpfCandidatoOptional.isPresent()) {
            throw new DuplicateEntryException("Cpf already exist");
        }
        Optional<Candidato> verifyEmailCandidatoOptional = Optional.ofNullable(candidatoRepository.findByEmail(candidatoToSave.getEmail()));
        if(verifyEmailCandidatoOptional.isPresent()) {
            throw new DuplicateEntryException("Email already exist");
        }

        candidatoRepository.save(candidatoToSave);
        CandidatoDto savedCandidato = CandidatoDto.candidatoToCandidatoDto(candidatoToSave);
        return savedCandidato;
    }


    public List<InfoCandidatoDto> getAllCandidatos() {
        List<Candidato> listCandidato = candidatoRepository.findAll();
        List<InfoCandidatoDto> fullList = new ArrayList<>();
        listCandidato.forEach(candidato -> {
            List<Ensino> ensinoList = candidato.getEnsinoList();
            List<EnsinoDto> ensinoDtoList = ensinoList.stream()
                    .map(EnsinoDto::ensinoToEnsinoDto)
                    .collect(Collectors.toList());
            List<Experiencia> experienciaList = candidato.getExperieciaList();
            List<ExperienciaDto> experienciaDtoList = experienciaList.stream()
                    .map(ExperienciaDto::experienciaToExperienciaDto)
                    .toList();
            InfoCandidatoDto infoCandidatoDto = new InfoCandidatoDto(
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
            fullList.add(infoCandidatoDto);
        });
        return fullList;
    }
}
