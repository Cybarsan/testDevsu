package test.devsu.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
public class ValorMovimientoInvalidoException extends RuntimeException {
    public ValorMovimientoInvalidoException(String s) {
        super (s);
    }
}
