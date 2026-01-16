package cl.duoc.perfulandia.catalogo_service.service;

import cl.duoc.perfulandia.catalogo_service.DTO.ProductoCatalogoDTO;
import cl.duoc.perfulandia.catalogo_service.model.ProductoCatalogo;
import cl.duoc.perfulandia.catalogo_service.repository.CatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatalogoService {

    @Autowired
    private CatalogoRepository catalogoRepository;

    public List<ProductoCatalogo> listarTodo() {
        return catalogoRepository.findAll();
    }

    public List<ProductoCatalogo> buscarPorCategoria(String categoria) {
        return catalogoRepository.findByCategoria(categoria);
    }

    public ProductoCatalogo guardarProducto(ProductoCatalogoDTO dto) {
        ProductoCatalogo producto = new ProductoCatalogo();
        producto.setNombre(dto.getNombre());
        producto.setMarca(dto.getMarca());
        producto.setPrecio(dto.getPrecio());
        producto.setDescripcion(dto.getDescripcion());
        producto.setCategoria(dto.getCategoria());
        return catalogoRepository.save(producto);
    }
}