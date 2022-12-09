package com.example.CS3141R01Team2.Registration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmailValidator.class})
@ExtendWith(SpringExtension.class)
class EmailValidatorTest {
    @Autowired
    private EmailValidator emailValidator;

    /**
     * Method under test: {@link EmailValidator#test(String)}
     */
    @Test
    void testTest() {
        assertFalse(emailValidator.test("foo"));
        assertTrue(emailValidator.test("U.U.U@U.U.U.UUUU"));
    }
}

