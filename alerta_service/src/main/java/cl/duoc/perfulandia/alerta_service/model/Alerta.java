package cl.duoc.perfulandia.alerta_service.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "alertas")
@Data
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long productoId;
    private String mensaje;
    private LocalDateTime fechaAlerta;
    private String nivelPrioridad; // BAJA, MEDIA, CRITICA
}