package com.ajromero.domain.entity;

import com.ajromero.domain.payment.GenerateUUID;
import com.ajromero.domain.payment.IPayment;
import com.ajromero.domain.payment.IReserveFund;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name="purchase__order")
@Getter
@Setter
public class PurchaseOrder {
    @Id
    private String id;
    @Column
    private String fundReservedCode;
    @Column
    private String paymentCode;

    @OneToMany(mappedBy="order", cascade = CascadeType.ALL)
    private Set<OrderDetail> products;

    public PurchaseOrder(IReserveFund reserveFund, IPayment payment, Set<OrderDetail> products) {
        this(reserveFund, payment);
        if(products != null){
            this.products = new TreeSet<>(products);
        }else{
            this.products = new TreeSet<>();
        }
    }
    public PurchaseOrder(IReserveFund reserveFund, IPayment payment){
        this();
        this.fundReservedCode=reserveFund.reserveFunds();
        this.paymentCode = payment.pay();
    }
    public PurchaseOrder(){
        GenerateUUID uuid;
        uuid = GenerateUUID.getInstance();
        this.id = uuid.generateCode();
        this.products = new TreeSet<>();
    }
    public void addOrderDetail(OrderDetail orderDetail){
        orderDetail.setOrder(this);
        this.products.add(orderDetail);
    }

}
