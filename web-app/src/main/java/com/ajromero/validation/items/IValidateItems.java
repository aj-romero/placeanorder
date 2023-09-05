package com.ajromero.validation.items;

import com.ajromero.domain.dto.ProductDto;
//strategy pattern

public interface IValidateItems {
    boolean validate(ProductDto product);
}
