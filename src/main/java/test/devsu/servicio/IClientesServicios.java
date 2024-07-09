package test.devsu.servicio;

import jakarta.persistence.criteria.CriteriaBuilder;
import test.devsu.modelo.Clientes;

import java.util.List;

public interface IClientesServicios {
    public List<Clientes> listarClientes();

    public Clientes buscarClienteId(Integer idcliente);

    public Clientes guardarCliente(Clientes clientes);

    public void borrarClienteId(Integer idcliente);

}
