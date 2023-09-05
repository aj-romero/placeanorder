package com.ajromero.service;

import com.ajromero.domain.entity.PurchaseOrder;
import com.ajromero.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderService implements IPurchaseOrder {
    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public PurchaseOrder save(PurchaseOrder purchaseOrder) {
        return purchaseOrderRepository.save(purchaseOrder);
    }

}
