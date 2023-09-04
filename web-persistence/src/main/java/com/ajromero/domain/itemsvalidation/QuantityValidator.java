package com.ajromero.domain.itemsvalidation;

import com.ajromero.domain.Items;
import com.ajromero.domain.ProductDto;

public class QuantityValidator implements IValidateItems {
    @Override
    public boolean validate(ProductDto product) {
        return product.getQuantity() > 0;
    }

}
