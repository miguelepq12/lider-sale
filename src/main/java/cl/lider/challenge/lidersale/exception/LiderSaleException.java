package cl.lider.challenge.lidersale.exception;

import lombok.Generated;

@Generated
public class LiderSaleException extends RuntimeException {

    private static final long serialVersionUID = -820025001722622353L;

    private final String codigo;
    private final String mensaje;

    public LiderSaleException(String codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

}
