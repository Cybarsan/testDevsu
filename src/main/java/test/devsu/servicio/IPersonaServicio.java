package test.devsu.servicio;

import test.devsu.modelo.Persona;

import java.util.List;

public interface IPersonaServicio {

    public List<Persona> listarPersonas();
    public Persona buscarPersonaId(Integer idpersona);

    public Persona guardarPersona(Persona persona);

    public void borrarPersonaId(Integer idpersona);
}
