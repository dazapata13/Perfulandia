package cl.duoc.perfulandia.factura_service.Controller;

import cl.duoc.perfulandia.factura_service.DTO.FacturaDTO;
import cl.duoc.perfulandia.factura_service.Model.Factura;
import cl.duoc.perfulandia.factura_service.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @PostMapping("/emitir")
    public Factura emitir(@RequestBody FacturaDTO dto) {
        return facturaService.emitirFactura(dto);
    }
}