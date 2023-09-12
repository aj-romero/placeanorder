package com.ajromero.validation.items;

import com.ajromero.domain.dto.ProductDto;
import com.ajromero.validation.card.CheckCardValidNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeRangeTest {
    @Test
    void chainResponsabilityTest(){
        ProductDto product = new ProductDto(100,"102","USB",10.50,1);
        CodeRange validateCode = new CodeRange();
        QuantityValidator quantityValidator = new QuantityValidator();
        validateCode.nextValidate(quantityValidator);
        quantityValidator.nextValidate(null);

        assertNull(validateCode.validate(product));
    }

    @Test
    void checkValidCardNumber(){
        CheckCardValidNumber card = new CheckCardValidNumber();
        assertFalse(card.checkValidNumber("412011000000102M"));
    }

}