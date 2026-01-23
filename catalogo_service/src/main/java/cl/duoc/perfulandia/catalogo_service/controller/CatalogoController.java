package cl.duoc.perfulandia.catalogo_service.controller;

import cl.duoc.perfulandia.catalogo_service.BaseController.BaseController; // Importamos tu base
import cl.duoc.perfulandia.catalogo_service.model.ProductoCatalogo;
import cl.duoc.perfulandia.catalogo_service.service.CatalogoService;
import cl.duoc.perfulandia.catalogo_service.DTO.ProductoCatalogoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/catalogo")
@Tag(name = "Catálogo", description = "Endpoints para gestionar el catálogo de productos")
public class CatalogoController extends BaseController { // <-- HEREDAMOS AQUÍ

    @Autowired
    private CatalogoService catalogoService;

    @Operation(summary = "Listar productos", description = "Obtiene todos los perfumes disponibles en el catálogo")
    @GetMapping("/productos")
    public ResponseEntity<?> listar() {
        var productos = catalogoService.listarTodo();
        return successResponse(productos, "Catálogo obtenido con éxito");
    }

    @Operation(summary = "Buscar por categoría", description = "Filtra los productos por su categoría")
    @GetMapping("/categoria/{cat}")
    public ResponseEntity<?> buscar(@PathVariable String cat) {
        var productos = catalogoService.buscarPorCategoria(cat);
        return successResponse(productos, "Productos de la categoría " + cat + " encontrados");
    }

    @Operation(summary = "Agregar producto", description = "Registra un nuevo producto en el catálogo")
    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody ProductoCatalogoDTO dto) {
        var nuevoProducto = catalogoService.guardarProducto(dto);
        return successResponse(nuevoProducto, "Producto agregado correctamente");
    }
}