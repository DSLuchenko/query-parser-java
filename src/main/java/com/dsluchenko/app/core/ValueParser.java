package com.dsluchenko.app.core;

import com.dsluchenko.app.value.Value;

import java.util.List;
import java.util.Queue;

public interface ValueParser {
    List<Value> parseValues(String values);
}
