package com.ajromero.domain.dto;

import lombok.Getter;
import lombok.ToString;

@ToString
public class ProductDto implements Comparable<ProductDto> {
    @Getter private Integer id;
    @Getter private String code;
    @Getter private String name;
    @Getter private Double price;
    @Getter private Integer quantity;
    private ICalcTotal calculateTotal;

    public ProductDto(Integer id, String code, String name, Double price, Integer quantity) {
        this();
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

    public ProductDto() {
        this.calculateTotal = new CalculateTotal();
    }

    public ProductDto(Integer id, String code, String name, Double price) {
        this(id,code, name,price,0);
    }

    public Double calculateTotal() {
        return this.calculateTotal.calculateTotal(this);
    }

    @Override
    public int compareTo(ProductDto product) {
        return id.compareTo(product.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto productDto = (ProductDto) o;
        return this.id.equals(productDto.getId());
    }

    @Override
    public int hashCode() {
        return this.id.hashCode() + 58;
    }
}
