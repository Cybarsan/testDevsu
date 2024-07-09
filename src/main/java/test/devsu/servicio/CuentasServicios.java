package test.devsu.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.devsu.modelo.Cuentas;
import test.devsu.repositorio.CuentasRepositorio;

import java.util.List;

@Service
public class CuentasServicios implements ICuentasServicio {

    @Autowired
    private CuentasRepositorio cuentasRepositorio;

    @Override
    public List<Cuentas> listarCuentas(){
        return cuentasRepositorio.findAll();
    }

    @Override
    public Cuentas buscarCuentasID(Integer idcuenta) {
        return null;
    }

    @Override
    public Cuentas buscarCuentasNro(String nrocuenta) {
        return null;
    }

    @Override
    public Cuentas guardaCuenta(Cuentas cuentas) {

        return cuentasRepositorio.save(cuentas);
    }

    @Override
    public void borraCuentas(Cuentas cuentas) {

    }

    @Override
    public Cuentas buscaCuentasID(Integer idcuenta){
        Cuentas cuentas = cuentasRepositorio.findById(idcuenta).orElse(null);
        return cuentas;
    }

    /*@Override
    public Cuentas buscaCuentasNro(String nrocuenta){
        Cuentas cuentas = cuentasRepositorio.findOne(Cuenta<nrocuenta>);
    }  */

}
