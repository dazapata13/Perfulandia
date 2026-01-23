package com.example.auth_service.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Autenticación", description = "Servicio de Usuarios de Perfulandia")
public class AuthController extends BaseController { // <--- HEREDAR AQUÍ

    @Autowired
    private AuthService authService;

    @Operation(summary = "Registro", description = "Crea un nuevo usuario")
    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody UsuarioDTO usuarioDTO) {
        var resultado = authService.registrarUsuario(usuarioDTO);

        return successResponse(resultado, "Usuario creado con éxito");
    }
}