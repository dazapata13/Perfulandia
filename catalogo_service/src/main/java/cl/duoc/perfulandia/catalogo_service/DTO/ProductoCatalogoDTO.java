package cl.duoc.perfulandia.catalogo_service.DTO;

import lombok.Data;

@Data
public class ProductoCatalogoDTO {
    private String nombre;
    private String marca;
    private Double precio;
    private String descripcion;
    private String categoria;
}