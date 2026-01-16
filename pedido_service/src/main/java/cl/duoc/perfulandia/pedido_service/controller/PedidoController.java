package cl.duoc.perfulandia.pedido_service.controller;

import cl.duoc.perfulandia.pedido_service.DTO.PedidoDTO;
import cl.duoc.perfulandia.pedido_service.model.Pedido;
import cl.duoc.perfulandia.pedido_service.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/crear")
    public Pedido crear(@RequestBody PedidoDTO dto) {
        return pedidoService.crearPedido(dto);
    }
}