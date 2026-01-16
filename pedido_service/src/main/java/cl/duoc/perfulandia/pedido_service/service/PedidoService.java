package cl.duoc.perfulandia.pedido_service.service;

import cl.duoc.perfulandia.pedido_service.DTO.PedidoDTO;
import cl.duoc.perfulandia.pedido_service.model.Pedido;
import cl.duoc.perfulandia.pedido_service.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido crearPedido(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setClienteId(dto.getClienteId());
        pedido.setTotal(dto.getTotal());
        pedido.setFechaPedido(LocalDateTime.now());
        pedido.setEstado("PENDIENTE"); // Lógica de negocio inicial
        
        return pedidoRepository.save(pedido);
    }
}