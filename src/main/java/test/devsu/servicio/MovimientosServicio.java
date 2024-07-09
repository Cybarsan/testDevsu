package test.devsu.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.devsu.modelo.Cuentas;
import test.devsu.modelo.Movimientos;
import test.devsu.repositorio.CuentasRepositorio;
import test.devsu.repositorio.MovimientosRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientosServicio implements IMovimientosService{
    @Autowired
    private MovimientosRepositorio movimientosRepositorio;
    @Autowired
    private CuentasRepositorio cuentasRepositorio;


    @Override
    public List<Movimientos> listarMovimientos() {
       return movimientosRepositorio.findAll();
    }

    @Override
    public Movimientos buscarMovimientosId(Integer idmovimiento) {
        Movimientos movimientos = movimientosRepositorio.findById(idmovimiento).orElse(null);
        return movimientos;
    }

  /*  @Override
    public Movimientos buscarMonivimientosNro(String nrocuenta) {
        return null;
    }    */

    @Override
    public Movimientos guardarMovimiento(Movimientos movimientos) {
        public void registrarMovimiento(movimientos)  {
            private Integer idcuenta = movimientos.getCuentas().getIdcuenta();
            Optional<Cuentas> cuentas = cuentasRepositorio.findById(idcuenta);

            if (movimientos.getValormovimiento().compareTo(cuentas.getSaldoactual()) > 0) {
                 ("Saldo no disponible");
            }

            cuentas.setSaldoactual(cuentas.getSaldoactual().subtract(movimientos.getValormovimiento()));
            cuentasRepositorio.save(cuentas);

            movimientosRepositorio.save(movimientos);
        }
    }
}
