package com.ajromero.service;

import com.ajromero.domain.entity.PurchaseOrder;
import com.ajromero.repository.PurchaseOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderService implements IPurchaseOrder {

    private static final Logger LOG = LoggerFactory.getLogger(PurchaseOrderService.class);
    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public PurchaseOrder save(PurchaseOrder purchaseOrder) {
        LOG.debug("PurchaseOrder Service >> Saving Order-ID {}", purchaseOrder.getId());
        return purchaseOrderRepository.save(purchaseOrder);
    }

}
