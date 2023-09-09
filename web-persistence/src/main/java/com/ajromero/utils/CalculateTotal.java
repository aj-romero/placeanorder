package com.ajromero.utils;

import com.ajromero.domain.dto.ProductDto;
//Strategy pattern

public class CalculateTotal implements ICalcTotal {
    @Override
    public Double calculateTotal(ProductDto product) {
        return product.getPrice() * product.getQuantity();
    }
}
