package com.task;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class Calculator {
    int add(int a, int b) {
        return a + b;
    }
}

public class ParameterizedAddTest {

    Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "2, 3, 5",
            "10, 15, 25"
    })
    void testAdd(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }
}
