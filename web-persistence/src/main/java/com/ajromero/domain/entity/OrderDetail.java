package com.ajromero.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order__detail")
public class OrderDetail implements Comparable<OrderDetail> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "quantity")
    @Getter @Setter private Integer quantity;
    @Column(name = "price")
    @Getter @Setter private Double price;

    @ManyToOne
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order", nullable = false)
    private  PurchaseOrder order;

    public OrderDetail(Integer quantity, Double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = new Product(product);
    }

    public OrderDetail() {

    }

    public void setOrder(PurchaseOrder order) {
        this.order = new PurchaseOrder(order);
    }

    public void setProduct(Product product) {
        this.product = new Product(product);
    }

    public Product getProduct() {
        return new Product(this.product);
    }

    @Override
    public int compareTo(OrderDetail o) {
        return this.product.getId().compareTo(o.getProduct().getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderDetail orderDetail = (OrderDetail) o;
        return this.product.getId().equals(orderDetail.getProduct().getId());
    }

    @Override
    public int hashCode() {
        return this.product.getId().hashCode() + 58;
    }

}
