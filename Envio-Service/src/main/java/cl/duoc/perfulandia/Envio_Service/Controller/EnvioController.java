package cl.duoc.perfulandia.Envio_Service.Controller;

import cl.duoc.perfulandia.Envio_Service.DTO.EnvioDTO;
import cl.duoc.perfulandia.Envio_Service.model.Envio;
import cl.duoc.perfulandia.Envio_Service.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/envios")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @PostMapping("/despachar")
    public Envio despachar(@RequestBody EnvioDTO dto) {
        return envioService.prepararDespacho(dto);
    }
}