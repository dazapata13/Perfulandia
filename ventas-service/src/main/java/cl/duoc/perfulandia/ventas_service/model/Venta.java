package cl.duoc.perfulandia.venta_service.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "ventas")
@Data
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long pedidoId;
    private Double totalPagado;
    private String metodoPago; // EJ: DEBITO, CREDITO, TRANSFERENCIA
    private LocalDateTime fechaVenta;

    @PrePersist
    protected void onCreate() {
        this.fechaVenta = LocalDateTime.now();
    }
}