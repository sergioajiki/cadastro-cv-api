package com.cadastrorh.cadastroRHapi.repository;

import com.cadastrorh.cadastroRHapi.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmail(String email);

    Optional<Admin> findByUsername(String username);
}
