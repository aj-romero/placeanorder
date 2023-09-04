package com.ajromero.domain;

import lombok.Getter;
import lombok.ToString;

import java.util.Set;
import java.util.TreeSet;

@Getter
@ToString
public class PlaceAnOrder {
    private String name;
    private String creditCardNumber;
    private Set<ProductDto> products;

    public PlaceAnOrder(String name, String creditCardNumber, Set<ProductDto> products) {
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
