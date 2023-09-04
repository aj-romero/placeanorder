package com.ajromero.domain;

import com.ajromero.domain.payment.GenerateUUID;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

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

    //pendiente relacion de onetomay -- > list
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
    public PurchaseOrder(String fundReservedCode, String paymentCode){
        this();
        this.fundReservedCode=fundReservedCode;
        this.paymentCode = paymentCode;
    }
    public PurchaseOrder(){
        GenerateUUID uuid;
        uuid = GenerateUUID.getInstance();
        this.id = uuid.generateCode();
    }

}
