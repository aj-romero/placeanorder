package com.ajromero.domain.payment;

import java.util.UUID;
//design pattern singleton

public class GenerateUuid {

    private GenerateUuid() {
    }

    private static class RegisterGenerate {
        private static GenerateUuid intance = new GenerateUuid();
    }

    public static GenerateUuid getInstance() {
        return RegisterGenerate.intance;
    }

    public String generateCode() {
        return UUID.randomUUID().toString();
    }

}
