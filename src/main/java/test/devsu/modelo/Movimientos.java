package test.devsu.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movimientos  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idmovimiento;

    Integer entidad;
    Date fechamovimiento;
    BigDecimal valormovimiento;
    BigDecimal saldomovimiento;
    Boolean estado;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idcuenta")
    Cuentas cuentas;
}
