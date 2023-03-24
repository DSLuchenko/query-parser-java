package com.dsluchenko.app.value;

import java.util.Objects;

public abstract class Value {
    private Type type;
    private String value;

    public Value(String value, Type type) {
        this.value = prepareValue(value);
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    protected String prepareValue(String value) {
        return value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value1 = (Value) o;
        return type == value1.type && value.equals(value1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }
}
