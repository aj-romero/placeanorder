package com.ajromero.validation.card;

public class CheckRangeNumbers implements ICheckCardValidNumber {
    @Override
    public boolean checkValidNumber(String cardNumber) {
        int numbers = Integer.parseInt(cardNumber.substring(0, 4));
        return numbers >= 4111 && numbers <= 4222;
    }
}
