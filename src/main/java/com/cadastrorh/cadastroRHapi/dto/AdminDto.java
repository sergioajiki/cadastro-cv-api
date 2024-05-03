package com.cadastrorh.cadastroRHapi.dto;

import com.cadastrorh.cadastroRHapi.entity.Admin;
import com.cadastrorh.cadastroRHapi.entity.Ensino;

public record AdminDto(
        String email,
        String password
) {
    public static AdminDto adminToAdminDto(Admin admin){
        return new AdminDto(
                admin.getEmail(),
                admin.getPassword()
        );
    }

    public static Admin AdminDtoToAdmin(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setEmail(adminDto.email);
        admin.setPassword(adminDto.password);

        return admin;
    }
}
