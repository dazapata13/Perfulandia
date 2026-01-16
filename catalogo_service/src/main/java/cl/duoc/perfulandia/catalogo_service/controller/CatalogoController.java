package cl.duoc.perfulandia.catalogo_service.controller;

import cl.duoc.perfulandia.catalogo_service.model.ProductoCatalogo;
import cl.duoc.perfulandia.catalogo_service.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/catalogo")
public class CatalogoController {
    @Autowired
    private CatalogoService catalogoService;

    @GetMapping("/productos")
    public List<ProductoCatalogo> listar() {
        return catalogoService.listarTodo();
    }

    @GetMapping("/categoria/{cat}")
    public List<ProductoCatalogo> buscar(@PathVariable String cat) {
        return catalogoService.buscarPorCategoria(cat);
    }

    @PostMapping("/agregar")
    public ProductoCatalogo agregar(@RequestBody cl.duoc.perfulandia.catalogo_service.DTO.ProductoCatalogoDTO dto) {
        return catalogoService.guardarProducto(dto);
    }
}