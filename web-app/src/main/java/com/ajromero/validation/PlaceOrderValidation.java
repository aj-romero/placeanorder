package com.ajromero.validation;

import com.ajromero.domain.dto.PurchaseOrderDto;
import com.ajromero.service.ServiceResponse;
import com.ajromero.validation.card.CheckCardValidNumber;
import com.ajromero.validation.card.CheckFistNumbers;
import com.ajromero.validation.card.CheckRangeNumbers;
import com.ajromero.validation.card.ICheckCardValidNumber;
import com.ajromero.validation.items.ItemsValidator;
import org.springframework.stereotype.Component;

@Component
public class PlaceOrderValidation implements IPlaceOrderValidation {
    private final ServiceResponse serviceResponse;

    private final ItemsValidator validateItems;

    public PlaceOrderValidation() {
        this.serviceResponse = new ServiceResponse();
        this.validateItems = new ItemsValidator();
    }

    @Override
    public ServiceResponse validateOrder(PurchaseOrderDto po) {
        if (cardNumberValidate(new CheckCardValidNumber(), po)) {
            return buildServiceResponse(false,"The credit card number is not a valid number");
        }
        if (cardNumberValidate(new CheckFistNumbers(), po)) {
            return buildServiceResponse(false,"The credit card number does not start with 4000");
        }
        if (cardNumberValidate(new CheckRangeNumbers(), po)) {
            return buildServiceResponse(false,"The credit card number "
                    + "should be between 4111 and 4222");
        }
        if (po.calculateTotalList() <= 0) {
            return buildServiceResponse(false,"The total amount should be greater than zero.");
        }

        if (validateItems.validateItem(po.getProducts()) != null) {
            return buildServiceResponse(false,validateItems.validateItem(po.getProducts()));
        }

        return buildServiceResponse(true,"Well done");
    }

    private ServiceResponse buildServiceResponse(boolean status, String msj) {
        this.serviceResponse.setMessage(msj);
        this.serviceResponse.setSuccess(status);
        return serviceResponse;
    }

    private boolean cardNumberValidate(ICheckCardValidNumber validator, PurchaseOrderDto po) {
        return !validator.checkValidNumber(po.getCreditCardNumber());
    }


}
