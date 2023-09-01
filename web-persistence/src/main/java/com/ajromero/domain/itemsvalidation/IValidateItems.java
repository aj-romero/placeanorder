package com.ajromero.domain.itemsvalidation;

import com.ajromero.domain.Items;

public interface IValidateItems {
    boolean validate(Items item);
    void setNextValidation(IValidateItems validation);
}
