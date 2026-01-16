package cl.duoc.perfulandia.alerta_service.repository;



import cl.duoc.perfulandia.alerta_service.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta, Long> {
    // Al extender de JpaRepository, ya tienes el método .save() listo para usar.
}