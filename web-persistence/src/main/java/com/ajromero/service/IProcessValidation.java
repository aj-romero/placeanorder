package com.ajromero.service;

import com.ajromero.domain.PlaceAnOrder;

public interface IProcessValidation {
    ServiceResponse validateOrder(PlaceAnOrder po);

    ServiceResponse validateItems(PlaceAnOrder po);

    ServiceResponse updateInventory(PlaceAnOrder po);
}
