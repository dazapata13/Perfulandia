package cl.duoc.perfulandia.ventas_service.controller;

import cl.duoc.perfulandia.ventas_service.dto.VentaDTO;
import cl.duoc.perfulandia.ventas_service.model.Venta;
import cl.duoc.perfulandia.ventas_service.service.VentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService service;

    @GetMapping
    public List<Venta> listar() {
        return service.listarTodas();
    }

    @PostMapping
    public Venta crear(@Valid @RequestBody VentaDTO ventaDto) {
        Venta venta = new Venta();
        venta.setCliente(ventaDto.getCliente());
        venta.setProductoId(ventaDto.getProductoId());
        venta.setCantidad(ventaDto.getCantidad());
        venta.setTotal(ventaDto.getTotal());
        return service.registrarVenta(venta);
    }
}