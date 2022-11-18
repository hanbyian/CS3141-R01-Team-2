package com.example.CS3141R01Team2.Registration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UsernameValidatorTest {
    /**
     * Method under test: {@link UsernameValidator#test(String)}
     */
    @Test
    void testTest() {
        assertFalse((new UsernameValidator()).test("foo"));
        assertTrue((new UsernameValidator()).test("U"));
    }
}

