package cl.duoc.perfulandia.producto_service.controller;

import cl.duoc.perfulandia.producto_service.BaseController.BaseController;
import cl.duoc.perfulandia.producto_service.model.Producto;
import cl.duoc.perfulandia.producto_service.repository.ProductoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Productos", description = "Catálogo de perfumes de Perfulandia")
public class ProductoController extends BaseController {

    @Autowired
    private ProductoRepository productoRepository;

    @Operation(summary = "Obtener todo el catálogo")
    @GetMapping
    public ResponseEntity<?> listar() {
        return successResponse(productoRepository.findAll(), "Catálogo cargado con éxito");
    }

    @Operation(summary = "Agregar nuevo perfume al catálogo")
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Producto producto) {
        return successResponse(productoRepository.save(producto), "Producto agregado al catálogo");
    }
}