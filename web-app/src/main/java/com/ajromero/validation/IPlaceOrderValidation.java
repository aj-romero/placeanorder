package com.ajromero.validation;

import com.ajromero.domain.dto.PurchaseOrderDto;
import com.ajromero.service.ServiceResponse;

public interface IPlaceOrderValidation {

    ServiceResponse validateOrder(PurchaseOrderDto po);
}
