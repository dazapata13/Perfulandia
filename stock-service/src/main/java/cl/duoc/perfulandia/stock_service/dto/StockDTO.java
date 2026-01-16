package main.java.cl.duoc.perfulandia.stock_service.dto;

import lombok.Data;

@Data
public class StockDTO {
    private Long id;
    private Long productoId;
    private Integer cantidadActual;
}