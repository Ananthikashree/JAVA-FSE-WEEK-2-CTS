package com.helper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PerformanceTesterTest {
    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void testTaskPerformance() {
        PerformanceTester tester = new PerformanceTester();
        assertDoesNotThrow(() -> tester.performTask());
    }
}
