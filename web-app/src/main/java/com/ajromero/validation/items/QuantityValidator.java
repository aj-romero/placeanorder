package com.ajromero.validation.items;

import com.ajromero.domain.dto.ProductDto;

public class QuantityValidator implements IValidateItems {
    @Override
    public boolean validate(ProductDto product) {
        return product.getQuantity() > 0;
    }

}
