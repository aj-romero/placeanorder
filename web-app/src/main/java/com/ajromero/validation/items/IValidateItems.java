package com.ajromero.validation.items;

import com.ajromero.domain.ProductDto;
//strategy pattern
public interface IValidateItems {
    boolean validate(ProductDto product);
}
