package com.task;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorService {
    public int add(int a, int b) {
        return a + b;
    }
}

@SpringBootTest(classes = SpringTaskApplication.class)
public class CalculatorServiceTest {

    @Test
    void testAdd() {
        CalculatorService calc = new CalculatorService();
        assertEquals(5, calc.add(2, 3));
    }
}