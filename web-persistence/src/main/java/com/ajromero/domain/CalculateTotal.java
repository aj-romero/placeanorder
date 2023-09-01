package com.ajromero.domain;

public class CalculateTotal implements ICalcTotal{
    @Override
    public Double calculateTotal(Items item) {
        return (item.getPrice() * item.getQuantity());
    }
}
