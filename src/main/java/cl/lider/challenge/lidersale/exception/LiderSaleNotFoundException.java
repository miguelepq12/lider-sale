package cl.lider.challenge.lidersale.exception;

import lombok.Generated;

@Generated
public class LiderSaleNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -820025001722622353L;

    private final String mensaje;

    public LiderSaleNotFoundException(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

}