package cl.duoc.perfulandia.alerta_service;

import cl.duoc.perfulandia.alerta_service.entities.Alerta;
import cl.duoc.perfulandia.alerta_service.repositories.AlertaRepository;
import cl.duoc.perfulandia.alerta_service.services.AlertaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AlertaServiceTest {

    @Mock
    private AlertaRepository alertaRepository; 

    @InjectMocks
    private AlertaService alertaService; 

    @Test
    public void testObtenerAlertaPorId() {

        Alerta alertaFalsa = new Alerta();
        alertaFalsa.setId(1L);
        alertaFalsa.setMensaje("Stock bajo de perfume Chanel");
        
        when(alertaRepository.findById(1L)).thenReturn(Optional.of(alertaFalsa));


        Alerta resultado = alertaService.findById(1L);


        assertNotNull(resultado);
        assertEquals("Stock bajo de perfume Chanel", resultado.getMensaje());
        verify(alertaRepository, times(1)).findById(1L);
    }
}