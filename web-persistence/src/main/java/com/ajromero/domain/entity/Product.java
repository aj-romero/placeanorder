package com.ajromero.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
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

    public Product(Product product) {
        this(product.getCode(), product.getName(), product.getStock(), product.getPrice());
        this.id = product.getId();
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.stock - quantity;
        if (newQuantity >= 0) {
            this.stock = newQuantity;
        }
    }
}
