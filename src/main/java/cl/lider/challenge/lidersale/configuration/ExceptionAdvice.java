package cl.lider.challenge.lidersale.configuration;

import cl.lider.challenge.lidersale.exception.LiderSaleException;
import cl.lider.challenge.lidersale.exception.LiderSaleNotFoundException;
import lombok.Generated;
import org.springframework.http.HttpStatus;
import cl.lider.challenge.lidersale.exception.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Generated
public class ExceptionAdvice
{
    @ExceptionHandler({ LiderSaleException.class })
    public ResponseEntity<Error> mapException(LiderSaleException ose) {
        Error error = new Error(ose.getCodigo(), ose.getMensaje());
        return (ResponseEntity<Error>)new ResponseEntity((Object)error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({ LiderSaleNotFoundException.class })
    public ResponseEntity<Error> mapException(LiderSaleNotFoundException ose) {
        Error error = new Error(HttpStatus.NOT_FOUND.name(), ose.getMensaje());
        return (ResponseEntity<Error>)new ResponseEntity((Object)error, HttpStatus.NOT_FOUND);
    }
}
