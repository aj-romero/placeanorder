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
    private Set<Items> items;

    public PlaceAnOrder(String name, String creditCardNumber, Set<Items> items) {
        this.name = name;
        this.creditCardNumber = creditCardNumber;
        if(items != null){
            this.items = new TreeSet<>(items);
        }else{
            this.items = new TreeSet<>();
        }
    }

    public double calculateTotalList() {
        double totalList = 0;
        totalList = this.items.stream().mapToDouble(Items::calculateTotal).sum();
        return totalList;
    }
}
