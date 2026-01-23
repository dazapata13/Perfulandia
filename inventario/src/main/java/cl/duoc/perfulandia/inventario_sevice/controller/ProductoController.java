package cl.duoc.perfulandia.inventario.controller;

import cl.duoc.perfulandia.inventario.BaseController.BaseController;
import cl.duoc.perfulandia.inventario.model.Producto;
import cl.duoc.perfulandia.inventario.repository.ProductoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventario")
@Tag(name = "Inventario", description = "Gestión de stock de productos")
public class ProductoController extends BaseController {

    @Autowired
    private ProductoRepository productoRepository;

    @Operation(summary = "Ver stock completo")
    @GetMapping
    public ResponseEntity<?> listar() {
        return successResponse(productoRepository.findAll(), "Stock recuperado con éxito");
    }

    @Operation(summary = "Agregar o actualizar stock")
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Producto producto) {
        return successResponse(productoRepository.save(producto), "Inventario actualizado");
    }
}

