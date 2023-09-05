package com.ajromero.domain.payment;

public class ReserveFundByCC implements IReserveFund {

    @Override
    public String reserveFunds() {
        GenerateUuid generateUuid = GenerateUuid.getInstance();
        return generateUuid.generateCode();
    }
}
