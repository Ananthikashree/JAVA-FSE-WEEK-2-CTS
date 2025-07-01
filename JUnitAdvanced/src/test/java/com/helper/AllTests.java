package com.helper;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
@Suite
@SelectClasses({
        EmailValidatorTest.class,
        ExceptionThrowerTest.class,
        PerformanceTesterTest.class,
        OrderedTests.class
})
public class AllTests {
    // Suite entry point
}