package main.java.cl.duoc.perfulandia.stock_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "stocks")
@Data
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "producto_id", unique = true)
    private Long productoId;
    
    private Integer cantidadActual;
}