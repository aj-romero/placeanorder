package com.ajromero.validation.card;

public class CheckCardValidNumber implements ICheckCardValidNumber {

    @Override
    public boolean checkValidNumber(String cardNumber) {
        Long intCardNumber = 0L;
        try {
            intCardNumber = Long.parseLong(cardNumber);
        } catch (Exception ex) {
            return false;
        }
        return cardNumber.length() == 16;
    }
}
