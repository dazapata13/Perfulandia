package cl.duoc.perfulandia.catalogo_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "productos_catalogo")
@Data
public class ProductoCatalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String marca;
    private Double precio;
    private String descripcion;
    private String categoria; // Ejemplo: Cítrico, Amaderado, Floral
}