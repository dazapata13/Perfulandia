package cl.duoc.perfulandia.venta_service.controller;

import cl.duoc.perfulandia.venta_service.BaseController.BaseController;
import cl.duoc.perfulandia.venta_service.model.Venta;
import cl.duoc.perfulandia.venta_service.repository.VentaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ventas")
@Tag(name = "Ventas", description = "Registro de transacciones financieras")
public class VentaController extends BaseController {

    @Autowired
    private VentaRepository ventaRepository;

    @Operation(summary = "Ver historial de ventas")
    @GetMapping
    public ResponseEntity<?> listarTodas() {
        return successResponse(ventaRepository.findAll(), "Historial de ventas cargado");
    }

    @Operation(summary = "Registrar una nueva venta")
    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Venta venta) {
        return successResponse(ventaRepository.save(venta), "Venta registrada y boleta generada");
    }
}