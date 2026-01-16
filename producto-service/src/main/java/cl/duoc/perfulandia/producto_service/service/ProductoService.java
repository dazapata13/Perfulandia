package cl.duoc.perfulandia.producto_service.service;

import cl.duoc.perfulandia.producto_service.dto.ProductoDTO;
import cl.duoc.perfulandia.producto_service.model.Producto;
import cl.duoc.perfulandia.producto_service.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    public List<ProductoDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public ProductoDTO guardar(ProductoDTO dto) {
        Producto p = new Producto();
        p.setNombre(dto.getNombre());
        p.setMarca(dto.getMarca());
        p.setPrecio(dto.getPrecio());
        p.setStockMinimo(dto.getStockMinimo());
        
        Producto guardado = repository.save(p);
        return convertirADTO(guardado);
    }

    private ProductoDTO convertirADTO(Producto p) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setMarca(p.getMarca());
        dto.setPrecio(p.getPrecio());
        dto.setStockMinimo(p.getStockMinimo());
        return dto;
    }
}