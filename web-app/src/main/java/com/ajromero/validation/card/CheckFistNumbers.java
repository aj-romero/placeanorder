package com.ajromero.validation.card;

public class CheckFistNumbers implements ICheckCardValidNumber {
    @Override
    public boolean checkValidNumber(String cardNumber) {
        return !cardNumber.startsWith("4000");
    }
}
