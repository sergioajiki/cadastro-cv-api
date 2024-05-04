package com.cadastrorh.cadastroRHapi.dto;

import com.cadastrorh.cadastroRHapi.entity.Admin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AdminDto(
        @NotBlank(message = "Field username can not be null or empty")
        String username,
        @NotBlank(message = "Field email can not be null or empty")
        String email,
        @NotBlank(message = "Field password can not be null or empty")
        @Size(min = 6, max = 12, message = "Password must be between 6 and 12 characters")
        String password
) {
    public static AdminDto adminToAdminDto(Admin admin){
        return new AdminDto(
                admin.getUsername(),
                admin.getEmail(),
                admin.getPassword()
        );
    }

    public static Admin AdminDtoToAdmin(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setUsername(adminDto.username);
        admin.setEmail(adminDto.email);
        admin.setPassword(adminDto.password);

        return admin;
    }
}
