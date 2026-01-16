package main.java.cl.duoc.perfulandia.stock_service.controller;

import cl.duoc.perfulandia.stock_service.dto.StockDTO;
import cl.duoc.perfulandia.stock_service.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockService service;

    @GetMapping("/{productoId}")
    public StockDTO verStock(@PathVariable Long productoId) {
        return service.obtenerPorProducto(productoId);
    }

    @PostMapping("/actualizar")
    public StockDTO actualizar(@RequestBody StockDTO dto) {
        return service.actualizarStock(dto);
    }
}