package com.example.CS3141R01Team2.Registration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UsernameValidator.class})
@ExtendWith(SpringExtension.class)
class UsernameValidatorTest {
    @Autowired
    private UsernameValidator usernameValidator;

    /**
     * Method under test: {@link UsernameValidator#test(String)}
     */
    @Test
    void testTest() {
        assertFalse(usernameValidator.test("foo"));
        assertTrue(usernameValidator.test("U"));
    }
}

