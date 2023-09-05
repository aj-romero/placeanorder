package com.ajromero.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "price")
    private Double price;
    @Transient
    private Integer reserved;


    public Product(String code, String name, Integer stock, Double price) {
        this.code = code;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.reserved = 0;
    }
    public Product(){}

    public Integer getAvaibleStock() {
        return this.reserved != null?(this.stock - this.reserved): this.stock;
    }

    public Integer getReserved() {
        return this.reserved != null?this.reserved: 0;
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.stock - quantity;
        if(newQuantity >=0) {
            this.stock = newQuantity;
        }
    }
}
