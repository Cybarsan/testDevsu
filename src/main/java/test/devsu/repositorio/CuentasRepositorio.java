package test.devsu.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import test.devsu.modelo.Cuentas;


public interface CuentasRepositorio extends JpaRepository<Cuentas, Integer> {
}
