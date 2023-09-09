package com.ajromero.domain.entity;

import com.ajromero.utils.GenerateUuid;
import com.ajromero.utils.IPayment;
import com.ajromero.utils.IReserveFund;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import java.util.TreeSet;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "purchase__order")
@ToString
public class PurchaseOrder {
    @Id
    @Getter @Setter private String id;
    @Column
    @Getter @Setter private String fundReservedCode;
    @Column
    @Getter @Setter private String paymentCode;

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

    public PurchaseOrder(PurchaseOrder purchaseOrder) {
        this();
        this.fundReservedCode = purchaseOrder.getFundReservedCode();
        this.paymentCode = purchaseOrder.paymentCode;
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetail.setOrder(this);
        this.products.add(orderDetail);
    }

    public Set<OrderDetail> getProducts() {
        return new TreeSet<>(this.products);
    }
}
