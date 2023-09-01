package com.ajromero.domain.itemsvalidation;

import com.ajromero.domain.Items;

public class CodeRange implements IValidateItems{
    @Override
    public boolean validate(Items item) {
        int code = Integer.parseInt(item.getCode());
        return code >= 239 && code <= 384;
    }

    @Override
    public void setNextValidation(IValidateItems validation) {

    }
}
