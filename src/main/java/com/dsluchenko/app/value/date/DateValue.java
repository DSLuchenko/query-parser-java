package com.dsluchenko.app.value.date;

import com.dsluchenko.app.value.Type;
import com.dsluchenko.app.value.Value;

public abstract class DateValue extends Value {
    public DateValue(String value, Type type) {
        super(value, type);
    }
}
