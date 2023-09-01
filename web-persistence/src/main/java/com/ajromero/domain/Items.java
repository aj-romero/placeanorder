package com.ajromero.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Items implements Comparable<Items>{
    private Integer id;
    private String code;
    private String name;
    private Double price;
    private Integer quantity;
    private ICalcTotal calculateTotal;

    public Items(Integer id, String code, String name, Double price, Integer quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.calculateTotal = new CalculateTotal();
    }

    public Double calculateTotal(){
        return this.calculateTotal.calculateTotal(this);
    }

    @Override
    public int compareTo(Items o) {
        return this.id.compareTo(o.getId());
    }


}
