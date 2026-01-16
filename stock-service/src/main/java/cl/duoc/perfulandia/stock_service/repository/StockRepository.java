package main.java.cl.duoc.perfulandia.stock_service.repository;

import cl.duoc.perfulandia.stock_service.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByProductoId(Long productoId);
}