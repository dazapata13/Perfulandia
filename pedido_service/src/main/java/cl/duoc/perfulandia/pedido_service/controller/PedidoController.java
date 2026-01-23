package cl.duoc.perfulandia.pedido_service.controller;

import cl.duoc.perfulandia.pedido_service.BaseController.BaseController;
import cl.duoc.perfulandia.pedido_service.model.Pedido;
import cl.duoc.perfulandia.pedido_service.repository.PedidoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
@Tag(name = "Pedidos", description = "Operaciones de órdenes de compra")
public class PedidoController extends BaseController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Operation(summary = "Obtener todos los pedidos")
    @GetMapping
    public ResponseEntity<?> listar() {
        return successResponse(pedidoRepository.findAll(), "Lista de pedidos recuperada");
    }

    @Operation(summary = "Crear un nuevo pedido")
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Pedido pedido) {
        pedido.setEstado("PENDIENTE");
        return successResponse(pedidoRepository.save(pedido), "Pedido registrado exitosamente");
    }
}