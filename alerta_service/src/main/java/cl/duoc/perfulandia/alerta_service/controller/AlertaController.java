package cl.duoc.perfulandia.alerta_service.controller;

import cl.duoc.perfulandia.alerta_service.DTO.AlertaDTO;
import cl.duoc.perfulandia.alerta_service.model.Alerta;
import cl.duoc.perfulandia.alerta_service.service.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alertas")
public class AlertaController {

    @Autowired
    private AlertaService alertaService;

    @PostMapping("/notificar")
    public Alerta crearAlerta(@RequestBody AlertaDTO dto) {
        return alertaService.procesarStockBajo(dto);
    }
}
//ASHDKBNASKDJBNAS