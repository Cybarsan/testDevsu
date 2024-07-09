package test.devsu.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idpersona;
    String nombres;
    String apellidos;
    Date fechanacimiento;
    String nroidentificacion;
    String telefono;
    String direccion;
    String genero;
    Integer edad;

    }
