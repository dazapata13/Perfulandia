package cl.duoc.perfulandia.cliente_service.service;

import cl.duoc.perfulandia.cliente_service.model.Cliente;
import cl.duoc.perfulandia.cliente_service.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> obtenerTodos() {
        return repository.findAll();
    }

    public Cliente guardarCliente(Cliente cliente) {
        return repository.save(cliente);
    }
}