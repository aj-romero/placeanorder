package com.ajromero.domain.itemsvalidation;

import com.ajromero.domain.Items;

public class QuantityValidator implements IValidateItems {
    @Override
    public boolean validate(Items item) {
        return item.getQuantity() > 0;
    }

    @Override
    public void setNextValidation(IValidateItems validation) {

    }
}
