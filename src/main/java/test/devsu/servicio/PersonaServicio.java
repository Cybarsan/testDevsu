package test.devsu.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.devsu.modelo.Persona;
import test.devsu.repositorio.PersonaRepositorio;

import java.util.List;

@Service
public class PersonaServicio implements IPersonaServicio {

    @Autowired
    private PersonaRepositorio productoRepositorio;
    @Override
    public List<Persona> listarPersonas() {
       return productoRepositorio.findAll();
    }

    @Override
    public Persona buscarPersonaId(Integer idpersona) {
        Persona persona = productoRepositorio.findById(idpersona).orElse(null);
        return persona;
    }

    @Override
    public Persona guardarPersona(Persona persona) {
        return productoRepositorio.save(persona);
    }

    @Override
    public void borrarPersonaId(Integer idpersona) {
        productoRepositorio.deleteById(idpersona);
    }
}
