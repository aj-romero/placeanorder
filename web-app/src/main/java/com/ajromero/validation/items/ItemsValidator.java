package com.ajromero.validation.items;

import com.ajromero.domain.ProductDto;

import java.util.Set;

public class ItemsValidator {
    private IValidateItems codeRange;
    private IValidateItems quantityValidator;

    public ItemsValidator() {
        codeRange = new CodeRange();
        quantityValidator = new QuantityValidator();
    }

    public boolean validateCode(Set<ProductDto> products) {
        return products.stream().allMatch(codeRange::validate);
    }
    public boolean validateQuantity(Set<ProductDto> products) {
        return products.stream().allMatch(quantityValidator::validate);
    }
}
