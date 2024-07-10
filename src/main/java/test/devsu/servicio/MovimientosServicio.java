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
public class MovimientosServicio implements IMovimientosService {
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

    @Override
    public Movimientos guardarMovimiento(Movimientos movimientos) {
        return movimientosRepositorio.save(movimientos);
    }


}
