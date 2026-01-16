package cl.duoc.perfulandia.inventario_sevice.repositori;

import cl.duoc.perfulandia.inventario_sevice.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
}