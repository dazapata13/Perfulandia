package cl.duoc.perfulandia.alerta_service.DTO;

import lombok.Data;

@Data
public class AlertaDTO {
    private Long productoId;
    private Integer stockActual;
    private String nombreProducto;
}