package com.helper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class EmailValidatorTest {
    EmailValidator validator = new EmailValidator();

    @ParameterizedTest
    @ValueSource(strings = {"test@example.com", "user.name@domain.co", "email123@abc.in"})
    void testValidEmails(String email) {
        assertTrue(validator.isValidEmail(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "plainaddress", "@missingusername.com", "missingatsign.com"})
    void testInvalidEmails(String email) {
        assertFalse(validator.isValidEmail(email));
    }
}
