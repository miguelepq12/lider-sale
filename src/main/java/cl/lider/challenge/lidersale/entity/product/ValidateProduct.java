package cl.lider.challenge.lidersale.entity.product;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

@Component
public class ValidateProduct {

    public static final String MENSAJE_ERROR ="Las busqueda de marca y descripción debe tener minimo 3 letras";

    public String validateData(String text){
        if(!NumberUtils.isCreatable(text)){
           return (!text.isEmpty()&&text.length()<=3)?MENSAJE_ERROR:"";
        }else{
            return "";
        }
    }
}
