package com.dsluchenko.app.core;

import com.dsluchenko.app.value.Value;
import com.dsluchenko.app.value.character.RsdChar;
import com.dsluchenko.app.value.character.RsdlpStr;
import com.dsluchenko.app.value.numeric.RsdLong;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("ParserTest")
class ParserTest {
    private ValueParser parser;
    private Map<String, String> testFiles;

    @BeforeAll
    void injectParser(){
        parser = new Parser();
    }

    @BeforeAll
    void loadTestDataFromFiles() throws IOException {
        Path testResourcePath = Paths.get("src", "test", "resources");

        testFiles = Files.list(testResourcePath)
                .collect(Collectors.toMap(
                        p -> {
                            StringBuilder fileName = new StringBuilder(p.toFile().getName());
                            fileName.delete(fileName.indexOf("."), fileName.length());
                            return fileName.toString();
                        },
                        p -> {
                            String fileData;
                            try (BufferedReader bufferedReader = Files.newBufferedReader(p)) {
                                fileData = bufferedReader
                                        .lines().collect(Collectors.joining("\n"));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            return fileData;
                        }));

    }

    @Test
    @DisplayName("parseValuesTwoLongValueTest")
    void parseValuesTwoLongValueTest() {
        Value firstLongValue = new RsdLong("-2147483648");
        Value secondLongValue = new RsdLong("1");

        List<Value> expectedValues = new ArrayList<>();

        expectedValues.add(firstLongValue);
        expectedValues.add(secondLongValue);

        String inputString = testFiles.get("TwoLongValue");

        List<Value> actualValues = parser.parseValues(inputString);

        assertEquals(actualValues, expectedValues);
    }

    @Test
    @DisplayName("parseValuesThreeValuesStrCharLong")
    void parseValuesThreeValuesStrCharLong() {
        Value firstStrValue = new RsdlpStr("ОперацияRSBank|29015|10");
        Value secondCharValue = new RsdChar("0");
        Value thirdLongValue = new RsdLong("17");

        List<Value> expectedValues = new ArrayList<>();

        expectedValues.add(firstStrValue);
        expectedValues.add(secondCharValue);
        expectedValues.add(thirdLongValue);

        String inputString = testFiles.get("ThreeValuesStrCharLong");

        List<Value> actualValues = parser.parseValues(inputString);

        assertEquals(actualValues, expectedValues);
    }
}