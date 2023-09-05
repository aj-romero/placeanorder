package com.ajromero.domain.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.Set;
import java.util.TreeSet;

@Getter
@ToString
public class PurchaseOrderDto {
    private String name;
    private String creditCardNumber;
    private Set<ProductDto> products;

    public PurchaseOrderDto(String name, String creditCardNumber, Set<ProductDto> products) {
        this.name = name;
        this.creditCardNumber = creditCardNumber;
        if(products != null){
            this.products = new TreeSet<>(products);
        }else{
            this.products = new TreeSet<>();
        }
    }

    public double calculateTotalList() {
        double totalList = 0;
        totalList = this.products.stream().mapToDouble(ProductDto::calculateTotal).sum();
        return totalList;
    }

}
