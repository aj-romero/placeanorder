package com.ajromero.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceResponse {
    private boolean success;
    private String message;
    private String orderId;
    private String fundReservedCode;
    private String paymentCode;
}
