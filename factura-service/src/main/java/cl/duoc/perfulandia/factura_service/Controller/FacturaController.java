package cl.duoc.perfulandia.factura_service.controller;

import cl.duoc.perfulandia.factura_service.BaseController.BaseController;
import cl.duoc.perfulandia.factura_service.model.Factura;
import cl.duoc.perfulandia.factura_service.repository.FacturaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/factura")
@Tag(name = "Facturas", description = "Endpoints para la gestión de facturación")
public class FacturaController extends BaseController {

    @Autowired
    private FacturaRepository facturaRepository;

    @Operation(summary = "Obtener todas las facturas emitidas")
    @GetMapping
    public ResponseEntity<?> obtenerTodas() {
        return successResponse(facturaRepository.findAll(), "Lista de facturas obtenida");
    }

    @Operation(summary = "Generar una nueva factura")
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Factura factura) {

        factura.setFolio("FAC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        return successResponse(facturaRepository.save(factura), "Factura generada con éxito");
    }
}