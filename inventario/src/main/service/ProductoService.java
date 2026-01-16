package cl.duoc.perfulandia.inventario_sevice.service;

import cl.duoc.perfulandia.inventario_sevice.model.Producto;
import cl.duoc.perfulandia.inventario_sevice.repositori.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;


    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }

    public List<Producto> listarTodos() {
        return repository.findAll();
    }


    public Producto ajustarStock(Long id, Integer cantidadNueva) {
        Producto p = repository.findById(id).orElse(null);
        if (p != null) {
            p.setStockActual(cantidadNueva);
            return repository.save(p);
        }
        return null;
    }


    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}