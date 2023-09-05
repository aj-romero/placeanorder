package com.ajromero.domain.dto;

public class CalculateTotal implements ICalcTotal{
    @Override
    public Double calculateTotal(ProductDto product) {
        return (product.getPrice() * product.getQuantity());
    }
}
