package com.ajromero.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="order__detail")
@Getter
@Setter
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private Double price;

    //pendiente relacion relacion de muchos a uno
    @ManyToOne
    @JoinColumn(name="id_product", nullable=false)
    private Product product;

    @ManyToOne
    @JoinColumn(name="id_order", nullable=false)
    private PurchaseOrder order;
}
