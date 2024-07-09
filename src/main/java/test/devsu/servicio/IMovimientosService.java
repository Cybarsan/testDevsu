package test.devsu.servicio;

import jakarta.persistence.criteria.CriteriaBuilder;
import test.devsu.modelo.Cuentas;
import test.devsu.modelo.Movimientos;

import java.util.List;

public interface IMovimientosService {
    public List<Movimientos> listarMovimientos();

    public Movimientos buscarMovimientosId(Integer idmovimiento);

  /*  public Movimientos buscarMonivimientosNro(String nrocuenta); */

    public Movimientos guardarMovimiento(Movimientos movimientos);

}
