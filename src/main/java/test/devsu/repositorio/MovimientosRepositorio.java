package test.devsu.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import test.devsu.modelo.Movimientos;

public interface MovimientosRepositorio extends JpaRepository<Movimientos, Integer> {
}
