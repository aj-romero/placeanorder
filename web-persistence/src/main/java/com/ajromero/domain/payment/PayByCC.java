package com.ajromero.domain.payment;

public class PayByCC implements IPayment {

    @Override
    public String pay() {
        GenerateUuid generateUuid = GenerateUuid.getInstance();
        return generateUuid.generateCode();
    }
}
