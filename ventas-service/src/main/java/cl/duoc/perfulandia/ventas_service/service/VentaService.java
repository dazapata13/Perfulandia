package cl.duoc.perfulandia.ventas_service.service;


import cl.duoc.perfulandia.ventas_service.model.Venta;
import cl.duoc.perfulandia.ventas_service.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Venta> listarTodas() {
        return repository.findAll();
    }

    public Venta registrarVenta(Venta venta) {
        
        Venta nuevaVenta = repository.save(venta);


        String urlInventario = "http://localhost:8081/api/productos/" + venta.getProductoId() + "/stock";
        
        try {

            restTemplate.put(urlInventario, -venta.getCantidad());
            System.out.println("Stock actualizado en Inventario con éxito.");
        } catch (Exception e) {
            System.out.println("Error al conectar con Inventario: " + e.getMessage());
        }

        return nuevaVenta;
    }
}