package com.ajromero.service;

import com.ajromero.domain.PlaceAnOrder;
import com.ajromero.domain.ProcessPO;
import com.ajromero.domain.payment.ReserveFundByCC;

public class ProcessPOService implements IProcessValidation {
    private ProcessPO processPO;
    private ServiceResponse serviceResponse;

    public ProcessPOService() {
        this.processPO = new ProcessPO();
        this.serviceResponse = new ServiceResponse();
    }

    @Override
    public ServiceResponse validateOrder(PlaceAnOrder order) {
        return validate(order);
    }

    public ServiceResponse validate(PlaceAnOrder po){
        if(!processPO.validCardNumber(po.getCreditCardNumber())){
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("The credit card number is not a valid number");
            return serviceResponse;
        }
        if(!processPO.firsNumberValidation(po.getCreditCardNumber())){
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("The credit card number does not start with 4000");
            return serviceResponse;
        }
        if(!processPO.rangeNumberValidation(po.getCreditCardNumber())){
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("The credit card number should be between 4111 and 4222");
            return serviceResponse;
        }
        if(!(po.calculateTotalList() > 0)){
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("The total amount should be greater than zero.");
            return serviceResponse;
        }
        serviceResponse.setSuccess(true);
        serviceResponse.setMessage("Well done");
        return serviceResponse;
    }

    @Override
    public String getReserveFunds(){
        return processPO.getReserveFund(new ReserveFundByCC());
    }

}
