package cl.duoc.perfulandia.catalogo_service.repository;

import cl.duoc.perfulandia.catalogo_service.model.ProductoCatalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CatalogoRepository extends JpaRepository<ProductoCatalogo, Long> {
    List<ProductoCatalogo> findByCategoria(String categoria);
}