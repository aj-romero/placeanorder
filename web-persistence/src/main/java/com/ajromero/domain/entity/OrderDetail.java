package com.ajromero.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order__detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements Comparable<OrderDetail> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order", nullable = false)
    private PurchaseOrder order;

    @Override
    public int compareTo(OrderDetail o) {
        return this.product.getId().compareTo(o.getProduct().getId());
    }

}
