package cl.duoc.perfulandia.factura_service.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "facturas")
@Data
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String folio;
    private Double montoTotal;
    private LocalDateTime fechaEmision;
    private Long pedidoId;

    @PrePersist
    protected void onCreate() {
        fechaEmision = LocalDateTime.now();
    }
}