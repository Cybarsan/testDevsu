package test.devsu.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Cuentas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idcuenta;
    String nrocuenta;
    String tipocuenta;
    BigDecimal saldoinicial;
    BigDecimal saldoactual;
    Boolean estado;
    Date fechaapertura;

    Integer idcliente;

}
