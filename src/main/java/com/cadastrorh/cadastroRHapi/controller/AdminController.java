package com.cadastrorh.cadastroRHapi.controller;

import com.cadastrorh.cadastroRHapi.dto.AdminDto;
import com.cadastrorh.cadastroRHapi.dto.LoginDto;
import com.cadastrorh.cadastroRHapi.dto.TokenDto;
import com.cadastrorh.cadastroRHapi.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Admin")
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    private final AuthenticationManager authenticationManager;

    public AdminController(AdminService adminService, AuthenticationManager authenticationManager) {
        this.adminService = adminService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    @Operation(description = "Cadastra o administrador")
    public ResponseEntity<String> registerAdmin(@RequestBody @Valid AdminDto adminDto) {
        String adminRegistered = adminService.registerAdmin(adminDto);

        return ResponseEntity.status(HttpStatus.CREATED).body("Success! Admin " + adminRegistered + " registered");
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody @Valid LoginDto loginDto) {
        UsernamePasswordAuthenticationToken usernamePassword
                = new UsernamePasswordAuthenticationToken(loginDto.username(), loginDto.password());
        Authentication auth = authenticationManager.authenticate(usernamePassword);
        UserDetails admin = (UserDetails) auth.getPrincipal();
        TokenDto resultOfLogin = adminService.login(admin);
        return ResponseEntity.status(HttpStatus.OK).body(resultOfLogin);
    }
}
