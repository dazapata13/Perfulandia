package cl.duoc.perfulandia.ventas_service.repository;

import cl.duoc.perfulandia.ventas_service.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
}