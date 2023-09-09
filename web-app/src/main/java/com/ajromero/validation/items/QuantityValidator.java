package com.ajromero.validation.items;

import com.ajromero.domain.dto.ProductDto;

public class QuantityValidator implements IValidateProduct {

    private IValidateProduct validator;

    @Override
    public String validate(ProductDto product) {
        if (product.getQuantity() <= 0) {
            return "The quantity of " + product.getName() + " is not greater than zero";
        } else if (validator != null) {
            return validator.validate(product);
        } else {
            return null;
        }
    }

    @Override
    public void nextValidate(IValidateProduct validator) {
        this.validator = validator;
    }

}
