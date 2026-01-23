package cl.duoc.perfulandia.Envio_Service.controller;

import cl.duoc.perfulandia.Envio_Service.BaseController.BaseController;
import cl.duoc.perfulandia.Envio_Service.model.Envio;
import cl.duoc.perfulandia.Envio_Service.repository.EnvioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/envio")
@Tag(name = "Envíos", description = "Servicio de logística y seguimiento")
public class EnvioController extends BaseController {

    @Autowired
    private EnvioRepository envioRepository;

    @Operation(summary = "Ver todos los envíos")
    @GetMapping
    public ResponseEntity<?> listarTodos() {
        return successResponse(envioRepository.findAll(), "Lista de envíos obtenida");
    }

    @Operation(summary = "Generar un nuevo envío")
    @PostMapping("/generar")
    public ResponseEntity<?> generarEnvio(@RequestBody Envio envio) {

        envio.setCodigoSeguimiento("TRK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        envio.setEstado("PREPARANDO");
        return successResponse(envioRepository.save(envio), "Envío generado con éxito");
    }
}