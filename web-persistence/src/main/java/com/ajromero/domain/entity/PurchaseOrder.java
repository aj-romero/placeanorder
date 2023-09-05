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

    @OneToMany(mappedBy="order")
    private Set<OrderDetail> products;

    public PurchaseOrder(String fundReservedCode, String paymentCode, Set<OrderDetail> products) {
        this.fundReservedCode = fundReservedCode;
        this.paymentCode = paymentCode;
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
    }

}
