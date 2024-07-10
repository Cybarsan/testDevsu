package test.devsu.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.devsu.modelo.Cuentas;
import test.devsu.modelo.Movimientos;
import test.devsu.servicio.CuentasServicios;
import test.devsu.servicio.MovimientosServicio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("cuentas-app")
public class MovimientoControlador {
    @Autowired
    private MovimientosServicio movimientosServicio;
    @Autowired
    private CuentasServicios cuentasServicios;

    @GetMapping("/movimientos")
    public List<Movimientos> obtenerMovimientos(){
        List<Movimientos> movimientos = movimientosServicio.listarMovimientos();
        return movimientos;
    }



    @PutMapping("/movimientos")
    public ResponseEntity<Movimientos> grabarMovimiento(
    @RequestBody Movimientos movimientosRec) {
        try {


        BigDecimal valorMovimiento = movimientosRec.getValormovimiento();
        if (valorMovimiento == null || valorMovimiento.signum() == 0)
            throw new ValorMovimientoInvalidoException("El valor del movimiento no puede ser nulo ni cero");
        } catch (Exception e) {

        }
        Movimientos movimientos = new Movimientos();
        movimientos.setFechamovimiento(new Date());
        Integer idcuenta = movimientosRec.getCuentas().getIdcuenta();
        Cuentas cuentas = cuentasServicios.buscaCuentasID(idcuenta);

        if (cuentas.getSaldoactual().compareTo(BigDecimal.valueOf(0)) == 0
                && cuentas.getSaldoinicial().compareTo(BigDecimal.valueOf(0))== 0) {
            //Primermov
            cuentas.setSaldoactual(movimientosRec.getValormovimiento());
        } else {
            BigDecimal saldocta = cuentas.getSaldoactual();
            saldocta.add(movimientosRec.getValormovimiento());
        }
        movimientos.setEntidad(1);
        movimientos.setEstado(true);


        cuentas.getSaldoinicial().add(movimientosRec.getValormovimiento());
        BigDecimal saldoAct = cuentas.getSaldoactual();
        BigDecimal valorAct = movimientosRec.getValormovimiento();
        saldoAct = saldoAct.add(valorAct);
        movimientos.setValormovimiento(valorAct);
        movimientos.setSaldomovimiento(saldoAct);
        cuentas.setSaldoactual(saldoAct);
        movimientos.setSaldomovimiento(saldoAct);
        movimientos.setCuentas(cuentas);

        movimientosServicio.guardarMovimiento(movimientos);

        return ResponseEntity.ok(movimientos);
    }

}
