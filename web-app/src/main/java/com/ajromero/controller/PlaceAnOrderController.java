package com.ajromero.controller;

import com.ajromero.domain.PlaceAnOrder;
import com.ajromero.service.IProcessValidation;
import com.ajromero.service.ProcessPoService;
import com.ajromero.service.ServiceResponse;
import com.ajromero.validation.IPlaceOrderValidation;
import com.ajromero.validation.PlaceOrderValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/placeorder")
@CrossOrigin("*")
public class PlaceAnOrderController {
    @Autowired
    IProcessValidation processValidation;
    @Autowired
    IPlaceOrderValidation placeOrderValidation;

    public PlaceAnOrderController() {
        this.placeOrderValidation = new PlaceOrderValidation();
    }

    @PostMapping
    public ResponseEntity<ServiceResponse> save(@RequestBody PlaceAnOrder order) {

        ServiceResponse res = placeOrderValidation.validateOrder(order);
        /*if(res.isSuccess()){
            res = processValidation.validateItems(order);
            if(res.isSuccess()){
                res = processValidation.updateInventory(order);
            }
        }*/

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
