package cl.duoc.perfulandia.pedido_service.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long clienteId;
    private Long productoId;
    private Integer cantidad;
    private Double montoTotal;
    private String estado; // Ejemplo: PENDIENTE, COMPLETADO, CANCELADO
    private LocalDateTime fechaCreacion;

    @PrePersist //Es una anotación de JPA (Java Persistence API). Le dice a Spring Boot: 
    // "Oye, justo antes de insertar este registro por primera vez en la base de datos (antes del INSERT), ejecuta este método".
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
    }
}