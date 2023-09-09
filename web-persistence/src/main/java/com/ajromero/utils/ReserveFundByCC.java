package com.ajromero.utils;

public class ReserveFundByCC implements IReserveFund {

    @Override
    public String reserveFunds() {
        GenerateUuid generateUuid = GenerateUuid.getInstance();
        return generateUuid.generateCode();
    }
}
