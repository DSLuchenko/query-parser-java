package com.dsluchenko.app.value.character;

import com.dsluchenko.app.value.Type;

public class RsdlpStr extends CharacterValue {

    public RsdlpStr(String value) {
        super(value, Type.RSDLPSTR);
    }

    @Override
    protected String prepareValue(String value) {
        return value.equals("")
                ? "CHR(1)"
                : String.format("\'%s\'", value);
    }

}
