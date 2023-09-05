package com.ajromero.validation;

import com.ajromero.domain.dto.PurchaseOrderDto;
import com.ajromero.service.ServiceResponse;
import com.ajromero.validation.card.CheckCardValidNumber;
import com.ajromero.validation.card.CheckFistNumbers;
import com.ajromero.validation.card.CheckRangeNumbers;
import com.ajromero.validation.card.ICheckCardValidNumber;
import com.ajromero.validation.items.ItemsValidator;
import org.springframework.stereotype.Service;

@Service
public class PlaceOrderValidation implements IPlaceOrderValidation{
    private ServiceResponse serviceResponse;

    private ICheckCardValidNumber checkCardValidNumber;
    private ItemsValidator validateItems;

    public PlaceOrderValidation() {
        this.serviceResponse = new ServiceResponse();
        this.validateItems = new ItemsValidator();
    }

    @Override
    public ServiceResponse validateOrder(PurchaseOrderDto po) {
        if(!validCardNumber(new CheckCardValidNumber(),po)){
            return buildServiceResponse(false,"The credit card number is not a valid number");
        }
        if(!validCardNumber(new CheckFistNumbers(),po)){
            return buildServiceResponse(false,"The credit card number does not start with 4000");
        }
        if(!validCardNumber(new CheckRangeNumbers(),po)){
            return buildServiceResponse(false,"The credit card number should be between 4111 and 4222");
        }
        if (!(po.calculateTotalList() > 0)) {
            return buildServiceResponse(false,"The total amount should be greater than zero.");
        }
        if (!validateItems.validateCode(po.getProducts())) {
            return buildServiceResponse(false,"The product code is  between"
                    + " 239 – 384, and it is not acceptable");
        }
        if (!validateItems.validateQuantity(po.getProducts())) {
            return buildServiceResponse(false,"The quantity of the product is not greater than zero");
        }
        serviceResponse.setSuccess(true);
        serviceResponse.setMessage("Well done");
        return serviceResponse;
    }

    private ServiceResponse buildServiceResponse(boolean status, String msj){
        this.serviceResponse.setMessage(msj);
        this.serviceResponse.setSuccess(status);
        return serviceResponse;
    }

    private boolean validCardNumber(ICheckCardValidNumber validator, PurchaseOrderDto po){
        return validator.checkValidNumber(po.getCreditCardNumber());
    }


}
