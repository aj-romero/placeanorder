package com.ajromero.validation.items;

import com.ajromero.domain.dto.ProductDto;

public class CodeRange implements IValidateProduct {
    private IValidateProduct validator;


    @Override
    public String validate(ProductDto product) {
        int code = 0;
        boolean result = true;
        try {
            code = Integer.parseInt(product.getCode());
        } catch (Exception ex) {
            result = false;
        }
        if (result) {
            if (code >= 239 && code <= 384) {
                return product.getName() + " code is  between 239 – 384, and it is not acceptable";
            } else if (validator != null) {
                return validator.validate(product);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public void nextValidate(IValidateProduct validator) {
        this.validator = validator;
    }

}

