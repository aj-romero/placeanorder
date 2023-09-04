package com.ajromero.domain.payment;

public class PayByCC implements IPayment {
    private GenerateUUID generateUUID;

    @Override
    public String pay() {
        generateUUID = GenerateUUID.getInstance();
        return generateUUID.generateCode();
    }
}
