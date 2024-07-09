package test.devsu.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.devsu.modelo.Cuentas;
import test.devsu.servicio.CuentasServicios;

import java.util.List;

@RestController
@RequestMapping("cuentas-app")
public class CuentasControlador {
    private static final Logger logger = LoggerFactory.getLogger(CuentasControlador.class);

    @Autowired
    CuentasServicios cuentasServicios;

    @GetMapping("/cuentas")
    public List<Cuentas> obtenerCuentas(){
        List<Cuentas> cuentas = cuentasServicios.listarCuentas();
        return cuentas;
    }


    @PostMapping("/cuentas")
    public Cuentas agregarCuenta(@RequestBody Cuentas cuentas) {
        logger.info("Cuenta a agregar: " + cuentas);
        return cuentasServicios.guardaCuenta(cuentas);
    }
}
