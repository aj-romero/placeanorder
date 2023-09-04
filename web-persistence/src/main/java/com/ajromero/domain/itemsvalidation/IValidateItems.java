package com.ajromero.domain.itemsvalidation;

import com.ajromero.domain.ProductDto;

public interface IValidateItems {
    boolean validate(ProductDto product);
}
