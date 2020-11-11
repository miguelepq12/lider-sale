package cl.lider.challenge.lidersale.entity.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ValidateProductTest {

    static ValidateProduct validate;

    @BeforeAll
    static void beforeAll() {
        validate= new ValidateProduct();
    }

    @Test
    void validateDataWithNumberTest(){
        Assertions.assertEquals("", validate.validateData("1"));
    }

    @Test
    void validateDataEmptyTest(){
        Assertions.assertEquals("", validate.validateData(""));
    }

    @Test
    void validateDataWithOneTextTest(){
        Assertions.assertEquals(ValidateProduct.MENSAJE_ERROR, validate.validateData("s"));
    }

    @Test
    void validateDataWithThreeTextTest(){
        Assertions.assertEquals(ValidateProduct.MENSAJE_ERROR, validate.validateData("sds"));
    }

    @Test
    void validateDataSuccessfulTest(){
        Assertions.assertEquals("", validate.validateData("sdsdsa"));
    }
}
