package com.ajromero.validation.items;

import com.ajromero.domain.dto.ProductDto;
// chain responsability pattern

public interface IValidateProduct {
    String validate(ProductDto product);

    void nextValidate(IValidateProduct validator);
}
