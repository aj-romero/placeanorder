package com.ajromero.controller;

import com.ajromero.domain.dto.PurchaseOrderDto;
import com.ajromero.domain.entity.PurchaseOrder;
import com.ajromero.mapper.PurchaseOrderMapper;
import com.ajromero.service.IProductService;
import com.ajromero.service.IPurchaseOrder;
import com.ajromero.service.ServiceResponse;
import com.ajromero.validation.IPlaceOrderValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/placeorder")
@CrossOrigin("*")
public class PlaceAnOrderController {
    @Autowired
    IProductService productService;
    @Autowired
    IPlaceOrderValidation placeOrderValidation;
    @Autowired
    PurchaseOrderMapper purchaseOrderMapper;
    @Autowired
    private IPurchaseOrder orderPlace;


    @PostMapping
    public ResponseEntity<ServiceResponse> placeAnOrder(@RequestBody PurchaseOrderDto order) {

        ServiceResponse res = placeOrderValidation.validateOrder(order);
        if (res.isSuccess()) {
            PurchaseOrder purchaseOrder = purchaseOrderMapper.apply(order);
            orderPlace.save(purchaseOrder);
            res = productService.updateInventory(purchaseOrder);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
