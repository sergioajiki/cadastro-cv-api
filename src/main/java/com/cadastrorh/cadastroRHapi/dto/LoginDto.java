package com.cadastrorh.cadastroRHapi.dto;

import com.cadastrorh.cadastroRHapi.entity.Admin;
import jakarta.validation.constraints.NotBlank;

public record LoginDto(
        @NotBlank(message = "Field user can not be null or empty")
        String user,
        @NotBlank(message = "Field password can not be null or empty")
        String password
) {
    public static Admin loginDtodoAdmin(LoginDto loginDto) {
        Admin user = new Admin();
        user.setEmail(loginDto.user);
        user.setPassword(loginDto.password);
        return user;
    }
}
