package cl.duoc.perfulandia.alerta_service.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alerta")
@Tag(name = "Controlador de Alertas", description = "Endpoints para gestionar las alertas de Perfulandia")
public class AlertaController extends BaseController { 
    
    @Operation(summary = "Listar alertas", description = "Retorna todas las alertas de stock de la base de datos")
    @GetMapping
    public ResponseEntity<?> obtenerTodas() {
        try {

            return successResponse("Lista de alertas", "Operación exitosa");
        } catch (Exception e) {
            return errorResponse("Error al obtener alertas", 500);
        }
    }
}