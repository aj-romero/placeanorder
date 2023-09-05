package com.ajromero.domain.payment;

public class ReserveFundByCC implements IReserveFund {
    private GenerateUUID generateUUID;

    @Override
    public String reserveFunds() {
        generateUUID = GenerateUUID.getInstance();
        return generateUUID.generateCode();
    }
}
