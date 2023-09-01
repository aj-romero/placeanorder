package com.ajromero.domain;

import com.ajromero.domain.payment.IReserveFund;
import com.ajromero.iplaceorder.CheckCardValidNumber;
import com.ajromero.iplaceorder.CheckFistNumbers;
import com.ajromero.iplaceorder.CheckRangeNumbers;
import com.ajromero.iplaceorder.ICheckCardValidNumber;

public class ProcessPO {
    private ICheckCardValidNumber cardNumberValidation;
    private ICheckCardValidNumber firstNumberCardValidation;
    private ICheckCardValidNumber rangeNumberCardValidation;


    public ProcessPO() {
        this.cardNumberValidation = new CheckCardValidNumber();
        this.firstNumberCardValidation = new CheckFistNumbers();
        this.rangeNumberCardValidation = new CheckRangeNumbers();
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
}
