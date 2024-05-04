package com.cadastrorh.cadastroRHapi.controller;

import com.cadastrorh.cadastroRHapi.dto.AdminDto;
import com.cadastrorh.cadastroRHapi.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Admin")
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    @Operation(description = "Cadastra o administrador")
    public ResponseEntity<String> registerAdmin(@RequestBody @Valid AdminDto adminDto) {
        String adminRegistered = adminService.registerAdmin(adminDto);

        return ResponseEntity.status(HttpStatus.CREATED).body("Success! Admin " + adminRegistered + " registered");
    }

}
