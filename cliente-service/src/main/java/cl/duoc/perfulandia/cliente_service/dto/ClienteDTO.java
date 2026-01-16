package cl.duoc.perfulandia.cliente_service.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ClienteDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Email(message = "El formato de correo no es válido")
    @NotBlank(message = "El correo es obligatorio")
    private String email;

    @Size(min = 9, message = "El telefono debe tener al menos 9 dígitos")
    private String telefono;
}}

//asdnklasndklas