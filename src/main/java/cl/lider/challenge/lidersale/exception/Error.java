package cl.lider.challenge.lidersale.exception;

import lombok.Data;
import lombok.Generated;

@Generated
@Data
public class Error {

    private String errorCode;
    private String errorMessage;

    public Error(String value, String message) {
        this.errorCode = value;
        this.errorMessage = message;
    }

}
