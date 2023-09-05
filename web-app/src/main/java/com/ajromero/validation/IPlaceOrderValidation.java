package com.ajromero.validation;

import com.ajromero.domain.PlaceAnOrder;
import com.ajromero.service.ServiceResponse;

public interface IPlaceOrderValidation {

    ServiceResponse validateOrder(PlaceAnOrder po);
}
