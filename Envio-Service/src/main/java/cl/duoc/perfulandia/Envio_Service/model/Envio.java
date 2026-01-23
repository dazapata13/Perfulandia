package cl.duoc.perfulandia.Envio_Service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "envios")
@Data
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String codigoSeguimiento;
    private String transportadora;
    private String estado; 
    private Long ventaId; 