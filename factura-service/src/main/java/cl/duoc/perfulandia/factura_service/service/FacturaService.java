package cl.duoc.perfulandia.factura_service.service;

import cl.duoc.perfulandia.factura_service.DTO.FacturaDTO;
import cl.duoc.perfulandia.factura_service.Model.Factura;
import cl.duoc.perfulandia.factura_service.Repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public Factura emitirFactura(FacturaDTO dto) {
        Factura factura = new Factura();
        factura.setVentaId(dto.getVentaId());
        factura.setEmailCliente(dto.getEmailCliente());
        factura.setMontoTotal(dto.getMontoTotal());
        
        // Generar folio único (Acción de negocio requerida)
        factura.setNumeroFactura("FAC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        factura.setFechaEmision(LocalDateTime.now());

        // Requerimiento del PDF: "Enviar por correo electrónico"
        System.out.println(">>> [LOGÍSTICA CORREO] Enviando factura " + factura.getNumeroFactura() + " a " + factura.getEmailCliente());
        
        return facturaRepository.save(factura);
    }
}