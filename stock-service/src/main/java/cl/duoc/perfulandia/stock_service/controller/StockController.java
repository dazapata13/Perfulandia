package cl.duoc.perfulandia.stock_service.controller;

import cl.duoc.perfulandia.stock_service.BaseController.BaseController;
import cl.duoc.perfulandia.stock_service.model.Stock;
import cl.duoc.perfulandia.stock_service.repository.StockRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock")
@Tag(name = "Stock", description = "Gestión de inventario físico y bodegaje")
public class StockController extends BaseController {

    @Autowired
    private StockRepository stockRepository;

    @Operation(summary = "Ver disponibilidad de stock")
    @GetMapping
    public ResponseEntity<?> listarTodo() {
        return successResponse(stockRepository.findAll(), "Inventario de stock recuperado");
    }

    @Operation(summary = "Actualizar niveles de stock")
    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Stock stock) {
        return successResponse(stockRepository.save(stock), "Stock actualizado correctamente");
    }
}