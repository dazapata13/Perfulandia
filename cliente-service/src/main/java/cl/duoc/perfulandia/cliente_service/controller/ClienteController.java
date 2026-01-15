package cl.duoc.perfulandia.cliente_service.controller;

import cl.duoc.perfulandia.cliente_service.dto.ClienteDTO;
import cl.duoc.perfulandia.cliente_service.model.Cliente;
import cl.duoc.perfulandia.cliente_service.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> listar() {
        return service.obtenerTodos();
    }

    @PostMapping
    public Cliente crear(@Valid @RequestBody ClienteDTO clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDto.getNombre());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setTelefono(clienteDto.getTelefono());
        return service.guardarCliente(cliente);
    }
}