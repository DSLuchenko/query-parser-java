package com.dsluchenko.app.value.numeric;

import com.dsluchenko.app.value.Type;
import com.dsluchenko.app.value.Value;

import java.util.Objects;

public abstract class NumericValue extends Value {
    public NumericValue(String value, Type type) {
        super(value, type);
    }

}
