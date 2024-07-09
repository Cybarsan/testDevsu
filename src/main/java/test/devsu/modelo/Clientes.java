package test.devsu.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idcliente;
    String contrasenia;
    Boolean estado;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "idpersona")
    private Persona persona;
 }
