package com.ajromero.utils;

public class PayByCC implements IPayment {

    @Override
    public String pay() {
        GenerateUuid generateUuid = GenerateUuid.getInstance();
        return generateUuid.generateCode();
    }
}
