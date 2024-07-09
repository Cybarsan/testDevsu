package test.devsu.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import test.devsu.modelo.Clientes;

public interface ClientesRepositorio extends JpaRepository<Clientes, Integer> {

}
