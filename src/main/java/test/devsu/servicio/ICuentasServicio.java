package test.devsu.servicio;

import test.devsu.modelo.Cuentas;

import java.util.List;

public interface ICuentasServicio {

    public List<Cuentas> listarCuentas();

    public Cuentas buscarCuentasID(Integer idcuenta);

    public  Cuentas buscarCuentasNro(String nrocuenta);

    public Cuentas guardaCuenta(Cuentas cuentas);

    public void borraCuentas(Cuentas cuentas);

    Cuentas buscaCuentasID(Integer idcuenta);
}
