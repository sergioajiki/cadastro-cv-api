package com.cadastrorh.cadastroRHapi.repository;

import com.cadastrorh.cadastroRHapi.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmail(String email);

    Optional<Admin> findByUsername(String username);
}
