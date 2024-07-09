package test.devsu.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import test.devsu.modelo.Persona;

public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {
}
