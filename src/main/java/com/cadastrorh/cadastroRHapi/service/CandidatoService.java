package com.cadastrorh.cadastroRHapi.service;

import com.cadastrorh.cadastroRHapi.dto.CandidatoDto;
import com.cadastrorh.cadastroRHapi.dto.InfoCandidatoDto;
import com.cadastrorh.cadastroRHapi.entity.Candidato;
import com.cadastrorh.cadastroRHapi.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidatoService {
    private final CandidatoRepository candidatoRepository;

    @Autowired
    public CandidatoService(CandidatoRepository candidatoRepository) {
        this.candidatoRepository = candidatoRepository;
    }

    public CandidatoDto registerCandidato(CandidatoDto candidatoDto) {
        Candidato candidatoToSave = CandidatoDto.candidatoDtoToCandidato(candidatoDto);

        candidatoRepository.save(candidatoToSave);
        CandidatoDto savedCandidato = CandidatoDto.candidatoToCandidatoDto(candidatoToSave);
        return savedCandidato;
    }

    public List<InfoCandidatoDto> getAllCandidatos() {
        List<Candidato> listCandidato = candidatoRepository.findAll();
        List<InfoCandidatoDto> fullList = new ArrayList<>();
        listCandidato.forEach(candidato -> {
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
                    candidato.getObservacao()
            );
            fullList.add(infoCandidatoDto);
        });
        return fullList;
    }
}
