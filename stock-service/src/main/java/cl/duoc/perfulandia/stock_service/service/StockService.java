package main.java.cl.duoc.perfulandia.stock_service.service;

import cl.duoc.perfulandia.stock_service.dto.StockDTO;
import cl.duoc.perfulandia.stock_service.model.Stock;
import cl.duoc.perfulandia.stock_service.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    public StockDTO obtenerPorProducto(Long productoId) {
        Stock stock = repository.findByProductoId(productoId)
                .orElseThrow(() -> new RuntimeException("No hay stock para producto ID: " + productoId));
        return convertirADTO(stock);
    }

    public StockDTO actualizarStock(StockDTO dto) {
        Stock stock = repository.findByProductoId(dto.getProductoId())
                .orElse(new Stock());
        
        stock.setProductoId(dto.getProductoId());
        stock.setCantidadActual(dto.getCantidadActual());
        
        Stock guardado = repository.save(stock);
        return convertirADTO(guardado);
    }

    private StockDTO convertirADTO(Stock s) {
        StockDTO dto = new StockDTO();
        dto.setId(s.getId());
        dto.setProductoId(s.getProductoId());
        dto.setCantidadActual(s.getCantidadActual());
        return dto;
    }
}