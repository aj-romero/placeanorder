package com.ajromero.domain.payment;

import java.util.UUID;
//design pattern singleton
public class GenerateUUID {

    private GenerateUUID() {
    }

    private static class registerGenerate{
        static GenerateUUID INSTANACE = new GenerateUUID();
    }

    public static GenerateUUID getInstance() {
        return registerGenerate.INSTANACE;
    }

    public String generateCode(){
        return UUID.randomUUID().toString();
    }

}
