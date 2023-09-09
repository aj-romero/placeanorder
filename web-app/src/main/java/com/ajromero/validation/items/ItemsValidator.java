package com.ajromero.validation.items;

import com.ajromero.domain.dto.ProductDto;
import java.util.Objects;
import java.util.Set;

public class ItemsValidator {
    private final IValidateProduct codeRange;
    private final IValidateProduct quantityValidator;

    public ItemsValidator() {
        codeRange = new CodeRange();
        quantityValidator = new QuantityValidator();
    }

    public String validateItem(Set<ProductDto> products) {
        codeRange.nextValidate(quantityValidator);
        return products.stream()
                .map(codeRange::validate)
                .filter(Objects::nonNull)
                .findFirst().orElse(null);
    }
}
