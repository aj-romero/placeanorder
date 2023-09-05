package com.ajromero.service;

import lombok.Data;

@Data
public class ServiceResponse {
    private boolean success;
    private String message;
    private String orderId;
    private String fundReservedCode;
    private String paymentCode;
}
