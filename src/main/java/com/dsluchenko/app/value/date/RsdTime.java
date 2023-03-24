package com.dsluchenko.app.value.date;

import com.dsluchenko.app.constant.Constant;
import com.dsluchenko.app.value.Type;

public class RsdTime extends DateValue {


    public RsdTime(String value) {
        super(value, Type.RSDTIME);
    }

    @Override
    protected String prepareValue(String value) {
        return String.format("\'to_date(\'01.01.0001 %s\', %s",
                value,
                Constant.DATE_TIME_MASK);
    }
}
