package test.devsu.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.devsu.modelo.Clientes;
import test.devsu.modelo.Persona;
import test.devsu.repositorio.ClientesRepositorio;
import test.devsu.servicio.ClientesServicio;
import test.devsu.servicio.PersonaServicio;

import java.util.List;

@RestController
@RequestMapping("clientes-app")
public class ClientesControlador {
    private static final Logger logger = LoggerFactory.getLogger(ClientesControlador.class);

    @Autowired
    private ClientesServicio clientesServicio;
    @Autowired
    private PersonaServicio personaServicio;

    @GetMapping("/clientes")
    public List<Clientes> obtenerClientes(){
        List<Clientes> clientes = clientesServicio.listarClientes();
        return clientes;
    }

    @PostMapping("/clientes")
    public Clientes agregarCliente(@RequestBody Clientes clientes){
        logger.info("Cliente Nuevo: " + clientes);
        return clientesServicio.guardarCliente(clientes);
    }

    @GetMapping("/clientes/{idcliente}")
    public ResponseEntity<Clientes> obtenerClienteID(@PathVariable Integer idcliente) {
        Clientes clientes = clientesServicio.buscarClienteId(idcliente);
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/clientes/{idcliente}")
    public ResponseEntity<Clientes> actualizarClienteId(
            @PathVariable Integer idcliente,
            @RequestBody Clientes clientesRec){
        Clientes clientes = clientesServicio.buscarClienteId(idcliente);
        clientes.setContrasenia(clientesRec.getContrasenia());
        clientes.setEstado(clientesRec.getEstado());
        Persona personare = clientesRec.getPersona();
        Persona persona = new Persona();
        persona.setIdpersona(personare.getIdpersona());
        persona.setEdad(personare.getEdad());
        persona.setDireccion(personare.getDireccion());
        persona.setNombres(personare.getNombres());
        persona.setApellidos(personare.getApellidos());
        persona.setTelefono(personare.getTelefono());
        persona.setGenero(personare.getGenero());
        persona.setNroidentificacion(personare.getNroidentificacion());
        persona.setFechanacimiento(personare.getFechanacimiento());
        clientes.setPersona(persona);
        clientesServicio.guardarCliente(clientes);
        return ResponseEntity.ok(clientes);

    }



}
