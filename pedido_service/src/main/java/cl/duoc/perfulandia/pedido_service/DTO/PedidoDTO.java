package cl.duoc.perfulandia.pedido_service.DTO;

import lombok.Data;

@Data
public class PedidoDTO {
    private Long clienteId;
    private Double total;
}