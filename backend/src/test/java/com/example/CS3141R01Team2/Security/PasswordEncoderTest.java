package com.example.CS3141R01Team2.Security;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PasswordEncoder.class})
@ExtendWith(SpringExtension.class)
class PasswordEncoderTest {
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Method under test: {@link PasswordEncoder#bCryptPasswordEncoder()}
     */
    @Test
    void testBCryptPasswordEncoder() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     BCryptPasswordEncoder.BCRYPT_PATTERN
        //     BCryptPasswordEncoder.logger
        //     BCryptPasswordEncoder.random
        //     BCryptPasswordEncoder.strength
        //     BCryptPasswordEncoder.version

        passwordEncoder.bCryptPasswordEncoder();
    }
}

