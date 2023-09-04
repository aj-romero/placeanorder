package com.ajromero.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@ToString
public class Items implements Comparable<Items>{
    @Getter private Integer id;
    @Getter private String code;
    @Getter private String name;
    @Getter private Double price;
    @Getter private Integer quantity;
    private ICalcTotal calculateTotal;

    public Items(Integer id, String code, String name, Double price, Integer quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.calculateTotal = new CalculateTotal();
    }
    public Items(Integer id, String code, String name, Double price) {
        this(id,code, name,price,0);
    }

   /* public Double calculateTotal(){
        return this.calculateTotal.calculateTotal(this);
    }*/

    @Override
    public int compareTo(Items o) {
        return this.id.compareTo(o.getId());
    }


}
