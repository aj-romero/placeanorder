package com.ajromero.domain.dto;

import java.util.Set;
import java.util.TreeSet;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class PurchaseOrderDto {
    private String name;
    private String creditCardNumber;
    private Set<ProductDto> products;

    public PurchaseOrderDto(String name, String creditCardNumber, Set<ProductDto> products) {
        this.name = name;
        this.creditCardNumber = creditCardNumber;
        if (products != null) {
            this.products = new TreeSet<>(products);
        } else {
            this.products = new TreeSet<>();
        }
    }

    public double calculateTotalList() {
        return this.products.stream().mapToDouble(ProductDto::calculateTotal).sum();
    }

}
