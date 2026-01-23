package cl.duoc.perfulandia.cliente_service.controller;

import cl.duoc.perfulandia.cliente_service.BaseController.BaseController; // Tu archivo de la foto
import cl.duoc.perfulandia.cliente_service.model.Cliente;
import cl.duoc.perfulandia.cliente_service.repository.ClienteRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Clientes", description = "Gestión de clientes")
public class ClienteController extends BaseController { //aqui se eredo

    @Autowired
    private ClienteRepository clienteRepository;

    @Operation(summary = "Listar clientes")
    @GetMapping
    public ResponseEntity<?> listar() {
        return successResponse(clienteRepository.findAll(), "Lista cargada");
    }

    @Operation(summary = "Crear cliente")
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Cliente cliente) {
        return successResponse(clienteRepository.save(cliente), "Cliente creado");
    }
}