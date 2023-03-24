package com.dsluchenko.app.core;

import com.dsluchenko.app.value.Value;
import com.dsluchenko.app.value.character.RsdChar;
import com.dsluchenko.app.value.character.RsdlpStr;
import com.dsluchenko.app.value.date.RsdDate;
import com.dsluchenko.app.value.date.RsdTime;
import com.dsluchenko.app.value.numeric.RsdLong;
import com.dsluchenko.app.value.numeric.RsdShort;
import com.dsluchenko.app.value.numeric.RsdptBigInt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser implements ValueParser {

    public List<Value> parseValues(String values) {

        return Arrays.stream(values.split("\n"))
                .map(l -> buildValue(l)
                ).collect(Collectors
                        .toList());
    }

    private Value buildValue(String typeAndValue) {
        String preparedType = prepareType(typeAndValue);
        String preparedValue = prepareValue(typeAndValue);

        return buildValueByType(preparedType, preparedValue);
    }

    private String prepareType(String stringWithType) {
        return stringWithType.substring(stringWithType.indexOf(", type ") + 7, stringWithType.indexOf(", value"));
    }

    private String prepareValue(String value) {
        String preparedValue = value.substring(value.indexOf("value: ") + 7);
        preparedValue = preparedValue.substring(0, preparedValue.indexOf("   "));

        return preparedValue;
    }

    private Value buildValueByType(String type, String value) throws IllegalArgumentException {

        switch (type) {
            case "RSDLPSTR":
                return new RsdlpStr(value);
            case "RSDLONG":
                return new RsdLong(value);
            case "RSDDATE":
                return new RsdDate(value);
            case "RSDSHORT":
                return new RsdShort(value);
            case "RSDCHAR":
                return new RsdChar(value);
            case "RSDTIME":
                return new RsdTime(value);
            case "RSDPT_BIGINT":
                return new RsdptBigInt(value);
            default:
                throw new IllegalArgumentException();
        }
    }
}
