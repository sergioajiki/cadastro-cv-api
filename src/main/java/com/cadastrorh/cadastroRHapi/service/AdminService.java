package com.cadastrorh.cadastroRHapi.service;

import com.cadastrorh.cadastroRHapi.dto.AdminDto;
import com.cadastrorh.cadastroRHapi.entity.Admin;
import com.cadastrorh.cadastroRHapi.exception.DuplicateEntryException;
import com.cadastrorh.cadastroRHapi.exception.InvalidEmailFormatException;
import com.cadastrorh.cadastroRHapi.repository.AdminRepository;
import com.cadastrorh.cadastroRHapi.util.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public String registerAdmin(AdminDto adminDto) {
        Admin adminToSave = AdminDto.AdminDtoToAdmin(adminDto);

        boolean isEmail = EmailValidator.isValidEmail(adminToSave.getEmail());
        if(!isEmail) {
            throw new InvalidEmailFormatException("Invalid email format");
        }

        Optional<Admin> adminOptional = Optional.ofNullable(adminRepository.findByEmail(adminDto.email()));
        if (adminOptional.isPresent()) {
            throw new DuplicateEntryException("Email is already registered");
        }
        adminRepository.save(adminToSave);
        AdminDto savedAdmin = AdminDto.adminToAdminDto(adminToSave);

        return savedAdmin.email();
    }

}
