package test.devsu.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.devsu.modelo.Clientes;
import test.devsu.repositorio.ClientesRepositorio;

import java.util.List;

@Service
public class ClientesServicio implements IClientesServicios {
    @Autowired
    private ClientesRepositorio clientesRepositorio;

    @Override
    public List<Clientes> listarClientes() {return clientesRepositorio.findAll();}

    @Override
    public Clientes buscarClienteId(Integer idcliente) {
        Clientes clientes = clientesRepositorio.findById(idcliente).orElse(null);
        return clientes;
    }


    @Override
    public void borrarClienteId(Integer idcliente) {
        clientesRepositorio.deleteById(idcliente);
    }


    @Override
    public Clientes guardarCliente(Clientes clientes) {
        return clientesRepositorio.save(clientes);
    }


}
