package cl.duoc.perfulandia.ventas_service.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class VentaDTO {
    
    @NotBlank(message = "El nombre del cliente es obligatorio")
    private String cliente;

    @NotNull(message = "El ID del producto es obligatorio")
    private Long productoId;

    @Min(value = 1, message = "La cantidad mínima es 1")
    private Integer cantidad;

    @Positive(message = "El precio debe ser mayor a 0")
    private Double total;
}