package cl.duoc.perfulandia.alerta_service.service;

import cl.duoc.perfulandia.alerta_service.DTO.AlertaDTO;
import cl.duoc.perfulandia.alerta_service.model.Alerta;
import cl.duoc.perfulandia.alerta_service.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    public Alerta procesarStockBajo(AlertaDTO dto) {
        if (dto != null && dto.getStockActual() != null && dto.getStockActual() <= 5) {
            Alerta alerta = new Alerta();
            alerta.setProductoId(dto.getProductoId());
            alerta.setFechaAlerta(LocalDateTime.now());
            
            String nombre = (dto.getNombreProducto() != null) ? dto.getNombreProducto() : "Producto Desconocido";
            alerta.setMensaje("ALERTA: El perfume '" + nombre + "' tiene stock bajo: " + dto.getStockActual());
            
            alerta.setNivelPrioridad(dto.getStockActual() <= 2 ? "CRITICA" : "MEDIA");
            
            return alertaRepository.save(alerta); 
        }
        return null;
    }
}