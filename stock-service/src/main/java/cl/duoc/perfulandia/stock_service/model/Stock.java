package cl.duoc.perfulandia.stock_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "stock")
@Data
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long productoId;
    private Integer cantidadDisponible;
    private String ubicacionBodega; 
}