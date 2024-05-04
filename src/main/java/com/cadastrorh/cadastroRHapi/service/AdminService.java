package com.cadastrorh.cadastroRHapi.service;

import com.cadastrorh.cadastroRHapi.dto.AdminDto;
import com.cadastrorh.cadastroRHapi.dto.TokenDto;
import com.cadastrorh.cadastroRHapi.entity.Admin;
import com.cadastrorh.cadastroRHapi.exception.DuplicateEntryException;
import com.cadastrorh.cadastroRHapi.exception.InvalidEmailFormatException;
import com.cadastrorh.cadastroRHapi.exception.InvalidLoginException;
import com.cadastrorh.cadastroRHapi.repository.AdminRepository;
import com.cadastrorh.cadastroRHapi.util.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService implements UserDetailsService {
    private final AdminRepository adminRepository;
    private final TokenService tokenService;

    @Autowired
    public AdminService(AdminRepository adminRepository, TokenService tokenService) {
        this.adminRepository = adminRepository;
        this.tokenService = tokenService;
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

        String hashedPassword = new BCryptPasswordEncoder()
                .encode(adminToSave.getPassword());
        adminToSave.setPassword(hashedPassword);

        adminRepository.save(adminToSave);
        AdminDto savedAdmin = AdminDto.adminToAdminDto(adminToSave);

        return savedAdmin.username();
    }

    public TokenDto login(UserDetails admin) {
        Optional<Admin> adminOptional = adminRepository.findByUsername(admin.getUsername());
        if(adminOptional.isEmpty()) {
            throw new InvalidLoginException("Username or password not found");
        }

        String token = tokenService.generateToken(admin.getUsername());
        return new TokenDto(token);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws InvalidLoginException {
        Optional<Admin> adminByUsernameOptional = adminRepository.findByUsername(username);
        if(adminByUsernameOptional.isEmpty()) {
            throw new InvalidLoginException("Username or password not found");
        }
        UserDetails admin = adminByUsernameOptional.get();
        return admin;
    }
}
