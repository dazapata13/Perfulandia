package com.example.auth_service.Controller;

import com.example.auth_service.dto.UsuarioDTO;
import com.example.auth_service.model.Usuario;
import com.example.auth_service.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/registrar")
    public Usuario registrar(@RequestBody UsuarioDTO usuarioDTO) {
        return authService.registrarUsuario(usuarioDTO);
    }

    @GetMapping("/usuarios")
    public List<Usuario> listar() {
        return authService.obtenerTodos();
    }
}