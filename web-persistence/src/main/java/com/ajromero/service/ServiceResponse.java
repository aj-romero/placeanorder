package com.ajromero.service;

import com.ajromero.domain.entity.PurchaseOrder;
import lombok.Data;

@Data
public class ServiceResponse {
  private boolean success;
  private String message;
  private String orderId;
  private String fundReservedCode;
  private String paymentCode;
}
