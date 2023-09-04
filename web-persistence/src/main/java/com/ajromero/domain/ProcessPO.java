package com.ajromero.domain;

import com.ajromero.domain.itemsvalidation.ItemsValidator;
import com.ajromero.domain.payment.IPayment;
import com.ajromero.domain.payment.IReserveFund;
import com.ajromero.iplaceorder.CheckCardValidNumber;
import com.ajromero.iplaceorder.CheckFistNumbers;
import com.ajromero.iplaceorder.CheckRangeNumbers;
import com.ajromero.iplaceorder.ICheckCardValidNumber;

import java.util.Set;

public class ProcessPO {
    private ICheckCardValidNumber cardNumberValidation;
    private ICheckCardValidNumber firstNumberCardValidation;
    private ICheckCardValidNumber rangeNumberCardValidation;
    private ItemsValidator itemsValidator;


    public ProcessPO() {
        this.cardNumberValidation = new CheckCardValidNumber();
        this.firstNumberCardValidation = new CheckFistNumbers();
        this.rangeNumberCardValidation = new CheckRangeNumbers();
        this.itemsValidator = new ItemsValidator();
    }
    public boolean validCardNumber(String cardNumber){
        return this.cardNumberValidation.checkValidNumber(cardNumber);

    }
    public boolean firsNumberValidation(String cardNumber){
        return this.firstNumberCardValidation.checkValidNumber(cardNumber);
    }

    public boolean rangeNumberValidation(String cardNumber){
        return this.rangeNumberCardValidation.checkValidNumber(cardNumber);
    }

    public String getReserveFund(IReserveFund reserveFund){
        return reserveFund.reserveFunds();
    }

    public boolean validateCodeRange(Set<ProductDto> products){
        return itemsValidator.validateCode(products);
    }
    public boolean validateQuantity(Set<ProductDto> products){
        return itemsValidator.validateQuantity(products);
    }

    public String getPayment(IPayment payment){
        return payment.pay();
    }
}
