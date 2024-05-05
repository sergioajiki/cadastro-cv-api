package com.cadastrorh.cadastroRHapi.repository;

import com.cadastrorh.cadastroRHapi.entity.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    Candidato findByCpf(String cpf);

    Candidato findByEmail(String email);

    List<Candidato> findByNomeContainingIgnoreCase(String nome);

    List<Candidato> findByNomeContainingIgnoreCaseAndSobrenomeContaining(String nome, String sobrenome);
}
