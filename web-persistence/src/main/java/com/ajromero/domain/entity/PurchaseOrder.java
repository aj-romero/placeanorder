package com.ajromero.domain.entity;

import com.ajromero.domain.payment.GenerateUuid;
import com.ajromero.domain.payment.IPayment;
import com.ajromero.domain.payment.IReserveFund;
import jakarta.persistence.*;
import java.util.Set;
import java.util.TreeSet;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "purchase__order")
@Getter
@Setter
public class PurchaseOrder {
    @Id
    private String id;
    @Column
    private String fundReservedCode;
    @Column
    private String paymentCode;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderDetail> products;

    public PurchaseOrder(IReserveFund reserveFund, IPayment payment, Set<OrderDetail> products) {
        this(reserveFund, payment);
        if (products != null) {
            this.products = new TreeSet<>(products);
        } else {
            this.products = new TreeSet<>();
        }
    }

    public PurchaseOrder(IReserveFund reserveFund, IPayment payment) {
        this();
        this.fundReservedCode = reserveFund.reserveFunds();
        this.paymentCode = payment.pay();
    }

    public PurchaseOrder() {
        GenerateUuid uuid;
        uuid = GenerateUuid.getInstance();
        this.id = uuid.generateCode();
        this.products = new TreeSet<>();
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetail.setOrder(this);
        this.products.add(orderDetail);
    }

}
