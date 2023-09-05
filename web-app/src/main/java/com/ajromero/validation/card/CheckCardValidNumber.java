package com.ajromero.validation.card;

public class CheckCardValidNumber implements ICheckCardValidNumber {

    @Override
    public boolean checkValidNumber(String cardNumber) {
        return cardNumber.length() == 16;
    }
}
