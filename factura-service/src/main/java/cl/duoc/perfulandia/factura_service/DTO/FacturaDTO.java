package cl.duoc.perfulandia.factura_service.DTO;

import lombok.Data;

@Data
public class FacturaDTO {
    private Long ventaId;
    private String emailCliente;
    private Double montoTotal;
}