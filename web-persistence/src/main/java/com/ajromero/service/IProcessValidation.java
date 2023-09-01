package com.ajromero.service;

import com.ajromero.domain.PlaceAnOrder;

public interface IProcessValidation {
    ServiceResponse validateOrder(PlaceAnOrder po);

    String getReserveFunds();
}
