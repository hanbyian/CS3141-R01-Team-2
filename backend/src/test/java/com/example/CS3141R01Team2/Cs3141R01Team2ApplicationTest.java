package com.example.CS3141R01Team2;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;

class Cs3141R01Team2ApplicationTest {
    /**
     * Method under test: {@link Cs3141R01Team2Application#configure(SpringApplicationBuilder)}
     */
    @Test
    void testConfigure() {
        Cs3141R01Team2Application cs3141R01Team2Application = new Cs3141R01Team2Application();
        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(Object.class);
        assertSame(springApplicationBuilder, cs3141R01Team2Application.configure(springApplicationBuilder));
    }

    /**
     * Method under test: {@link Cs3141R01Team2Application#configure(SpringApplicationBuilder)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConfigure2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.boot.builder.SpringApplicationBuilder.sources(java.lang.Class[])" because "application" is null
        //       at com.example.CS3141R01Team2.Cs3141R01Team2Application.configure(Cs3141R01Team2Application.java:38)
        //   See https://diff.blue/R013 to resolve this issue.

        (new Cs3141R01Team2Application()).configure(null);
    }

    /**
     * Method under test: {@link Cs3141R01Team2Application#simpleCorsFilter()}
     */
    @Test
    void testSimpleCorsFilter() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     SpringBootServletInitializer.logger
        //     SpringBootServletInitializer.registerErrorPageFilter

        (new Cs3141R01Team2Application()).simpleCorsFilter();
    }
}

