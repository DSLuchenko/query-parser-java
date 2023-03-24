package com.dsluchenko.app.value.date;

import com.dsluchenko.app.constant.Constant;
import com.dsluchenko.app.value.Type;

public class RsdDate extends DateValue {

    public RsdDate(String value) {
        super(value, Type.RSDDATE);
    }

    @Override
    protected String prepareValue(String value) {
        return value.equals(Constant.NEED_CHANGE_DATE_VALUE)
                ? Constant.START_DATE_VALUE
                : String.format("\'%s\'", value);
    }
}
