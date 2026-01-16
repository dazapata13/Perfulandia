package com.example.auth_service.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private String username;
    private String password;
    private String rol;
}