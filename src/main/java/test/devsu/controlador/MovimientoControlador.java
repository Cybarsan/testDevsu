package test.devsu.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.devsu.modelo.Movimientos;
import test.devsu.servicio.MovimientosServicio;

import java.util.List;

@RestController
@RequestMapping("cuentas-app")
public class MovimientoControlador {
    @Autowired
    private MovimientosServicio movimientosServicio;

    @GetMapping("/movimientos")
    public List<Movimientos> obtenerMovimientos(){
        List<Movimientos> movimientos = movimientosServicio.listarMovimientos();
        return movimientos;
    }

}
