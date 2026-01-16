package cl.duoc.perfulandia.factura_service.Repository;

import cl.duoc.perfulandia.factura_service.Model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
}