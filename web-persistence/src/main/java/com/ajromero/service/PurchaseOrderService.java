package com.ajromero.service;

import com.ajromero.domain.PurchaseOrder;
import com.ajromero.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PurchaseOrderService implements IPurchaseOrder{
    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;
    @Override
    public PurchaseOrder save(PurchaseOrder purchaseOrder) {
        return purchaseOrderRepository.save(purchaseOrder);
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }

    @Override
    public PurchaseOrder findById(String id) {
        return purchaseOrderRepository.findById(id).get();
    }
}
