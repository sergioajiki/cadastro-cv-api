package com.cadastrorh.cadastroRHapi.repository;

import com.cadastrorh.cadastroRHapi.entity.Ensino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnsinoRepository extends JpaRepository<Ensino, Long> {
}
