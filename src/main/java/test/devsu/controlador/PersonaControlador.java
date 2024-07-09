package test.devsu.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.LoggingCacheErrorHandler;
import org.springframework.web.bind.annotation.*;
import test.devsu.modelo.Persona;
import test.devsu.servicio.PersonaServicio;

import java.util.List;

@RestController
@RequestMapping("cuentas-app")
public class PersonaControlador {

    private static final Logger logger = LoggerFactory.getLogger(PersonaControlador.class);

    @Autowired
    private PersonaServicio personaServicio;

    @GetMapping("/persona")
    public List<Persona> obtenerPersonas(){
        List<Persona> personas = personaServicio.listarPersonas();
        return personas;
    }

    @PostMapping("/persona")
    public  Persona agregarPersona(@RequestBody Persona persona){
        logger.info("Persona agregada " + persona);
        return personaServicio.guardarPersona(persona);
    }
}
