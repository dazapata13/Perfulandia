package cl.duoc.perfulandia.factura_service.Model;

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
    
    private String numeroFactura;
    private Long ventaId;
    private String emailCliente;
    private Double montoTotal;
    private LocalDateTime fechaEmision;
}