package cl.duoc.perfulandia.Envio_Service.service;

import cl.duoc.perfulandia.Envio_Service.DTO.EnvioDTO;
import cl.duoc.perfulandia.Envio_Service.model.Envio;
import cl.duoc.perfulandia.Envio_Service.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    public Envio prepararDespacho(EnvioDTO dto) {
        Envio envio = new Envio();
        envio.setPedidoId(dto.getPedidoId());
        envio.setDireccionEntrega(dto.getDireccionEntrega());
        envio.setEstadoEnvio("EN PREPARACION");
        envio.setFechaDespacho(LocalDateTime.now());
        
        envio.setNumeroSeguimiento("TRK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        
        return envioRepository.save(envio);
    }
}