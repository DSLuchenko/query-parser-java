package com.dsluchenko.app.value.character;

import com.dsluchenko.app.value.Type;

public class RsdChar extends CharacterValue {


    public RsdChar(String value) {
        super(value, Type.RSDCHAR);

    }

    @Override
    protected String prepareValue(String value) {
        return String.format("CHR(%s)", value);
    }


}
