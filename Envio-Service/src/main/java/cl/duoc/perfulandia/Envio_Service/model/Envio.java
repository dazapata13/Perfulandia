package cl.duoc.perfulandia.Envio_Service.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "envios")
@Data
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long pedidoId;
    private String direccionEntrega;
    private String numeroSeguimiento;
    private String estadoEnvio; // EN PREPARACION, EN CAMINO, ENTREGADO
    private LocalDateTime fechaDespacho;
}