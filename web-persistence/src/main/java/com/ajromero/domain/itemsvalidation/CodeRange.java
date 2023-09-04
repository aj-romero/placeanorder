package com.ajromero.domain.itemsvalidation;

import com.ajromero.domain.ProductDto;

public class CodeRange implements IValidateItems{
    @Override
    public boolean validate(ProductDto product) {
        int code = Integer.parseInt(product.getCode());
        return !(code >= 239 && code <= 384);
    }
}

