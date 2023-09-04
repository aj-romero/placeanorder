package com.ajromero.service;

import com.ajromero.domain.PurchaseOrder;

import java.util.List;

public interface IPurchaseOrder {
    PurchaseOrder save(PurchaseOrder purchaseOrder);

    List<PurchaseOrder> getPurchaseOrders();

    PurchaseOrder findById(String id);
}
