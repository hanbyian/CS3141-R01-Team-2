package com.example.CS3141R01Team2.Registration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RegistrationRequestTest {
    /**
     * Method under test: {@link RegistrationRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org", "Name")).canEqual("Other"));
    }

    /**
     * Method under test: {@link RegistrationRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        RegistrationRequest registrationRequest = new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org",
                "Name");
        assertTrue(
                registrationRequest.canEqual(new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org", "Name")));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RegistrationRequest#RegistrationRequest(String, String, String, String)}
     *   <li>{@link RegistrationRequest#toString()}
     *   <li>{@link RegistrationRequest#getEmail()}
     *   <li>{@link RegistrationRequest#getName()}
     *   <li>{@link RegistrationRequest#getPassword()}
     *   <li>{@link RegistrationRequest#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        RegistrationRequest actualRegistrationRequest = new RegistrationRequest("janedoe", "iloveyou",
                "jane.doe@example.org", "Name");
        String actualToStringResult = actualRegistrationRequest.toString();
        assertEquals("jane.doe@example.org", actualRegistrationRequest.getEmail());
        assertEquals("Name", actualRegistrationRequest.getName());
        assertEquals("iloveyou", actualRegistrationRequest.getPassword());
        assertEquals("janedoe", actualRegistrationRequest.getUsername());
        assertEquals("RegistrationRequest(username=janedoe, password=iloveyou, email=jane.doe@example.org, name=Name)",
                actualToStringResult);
    }

    /**
     * Method under test: {@link RegistrationRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org", "Name"), null);
        assertNotEquals(new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org", "Name"),
                "Different type to RegistrationRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RegistrationRequest#equals(Object)}
     *   <li>{@link RegistrationRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        RegistrationRequest registrationRequest = new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org",
                "Name");
        assertEquals(registrationRequest, registrationRequest);
        int expectedHashCodeResult = registrationRequest.hashCode();
        assertEquals(expectedHashCodeResult, registrationRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RegistrationRequest#equals(Object)}
     *   <li>{@link RegistrationRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        RegistrationRequest registrationRequest = new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org",
                "Name");
        RegistrationRequest registrationRequest1 = new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org",
                "Name");

        assertEquals(registrationRequest, registrationRequest1);
        int expectedHashCodeResult = registrationRequest.hashCode();
        assertEquals(expectedHashCodeResult, registrationRequest1.hashCode());
    }

    /**
     * Method under test: {@link RegistrationRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        RegistrationRequest registrationRequest = new RegistrationRequest("iloveyou", "iloveyou", "jane.doe@example.org",
                "Name");
        assertNotEquals(registrationRequest,
                new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org", "Name"));
    }

    /**
     * Method under test: {@link RegistrationRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        RegistrationRequest registrationRequest = new RegistrationRequest(null, "iloveyou", "jane.doe@example.org",
                "Name");
        assertNotEquals(registrationRequest,
                new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org", "Name"));
    }

    /**
     * Method under test: {@link RegistrationRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        RegistrationRequest registrationRequest = new RegistrationRequest("janedoe", "janedoe", "jane.doe@example.org",
                "Name");
        assertNotEquals(registrationRequest,
                new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org", "Name"));
    }

    /**
     * Method under test: {@link RegistrationRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        RegistrationRequest registrationRequest = new RegistrationRequest("janedoe", null, "jane.doe@example.org",
                "Name");
        assertNotEquals(registrationRequest,
                new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org", "Name"));
    }

    /**
     * Method under test: {@link RegistrationRequest#equals(Object)}
     */
    @Test
    void testEquals8() {
        RegistrationRequest registrationRequest = new RegistrationRequest("janedoe", "iloveyou", "janedoe", "Name");
        assertNotEquals(registrationRequest,
                new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org", "Name"));
    }

    /**
     * Method under test: {@link RegistrationRequest#equals(Object)}
     */
    @Test
    void testEquals9() {
        RegistrationRequest registrationRequest = new RegistrationRequest("janedoe", "iloveyou", null, "Name");
        assertNotEquals(registrationRequest,
                new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org", "Name"));
    }

    /**
     * Method under test: {@link RegistrationRequest#equals(Object)}
     */
    @Test
    void testEquals10() {
        RegistrationRequest registrationRequest = new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org",
                "janedoe");
        assertNotEquals(registrationRequest,
                new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org", "Name"));
    }

    /**
     * Method under test: {@link RegistrationRequest#equals(Object)}
     */
    @Test
    void testEquals11() {
        RegistrationRequest registrationRequest = new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org",
                null);
        assertNotEquals(registrationRequest,
                new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org", "Name"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RegistrationRequest#equals(Object)}
     *   <li>{@link RegistrationRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals12() {
        RegistrationRequest registrationRequest = new RegistrationRequest(null, "iloveyou", "jane.doe@example.org",
                "Name");
        RegistrationRequest registrationRequest1 = new RegistrationRequest(null, "iloveyou", "jane.doe@example.org",
                "Name");

        assertEquals(registrationRequest, registrationRequest1);
        int expectedHashCodeResult = registrationRequest.hashCode();
        assertEquals(expectedHashCodeResult, registrationRequest1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RegistrationRequest#equals(Object)}
     *   <li>{@link RegistrationRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals13() {
        RegistrationRequest registrationRequest = new RegistrationRequest("janedoe", null, "jane.doe@example.org",
                "Name");
        RegistrationRequest registrationRequest1 = new RegistrationRequest("janedoe", null, "jane.doe@example.org",
                "Name");

        assertEquals(registrationRequest, registrationRequest1);
        int expectedHashCodeResult = registrationRequest.hashCode();
        assertEquals(expectedHashCodeResult, registrationRequest1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RegistrationRequest#equals(Object)}
     *   <li>{@link RegistrationRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals14() {
        RegistrationRequest registrationRequest = new RegistrationRequest("janedoe", "iloveyou", null, "Name");
        RegistrationRequest registrationRequest1 = new RegistrationRequest("janedoe", "iloveyou", null, "Name");

        assertEquals(registrationRequest, registrationRequest1);
        int expectedHashCodeResult = registrationRequest.hashCode();
        assertEquals(expectedHashCodeResult, registrationRequest1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RegistrationRequest#equals(Object)}
     *   <li>{@link RegistrationRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals15() {
        RegistrationRequest registrationRequest = new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org",
                null);
        RegistrationRequest registrationRequest1 = new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org",
                null);

        assertEquals(registrationRequest, registrationRequest1);
        int expectedHashCodeResult = registrationRequest.hashCode();
        assertEquals(expectedHashCodeResult, registrationRequest1.hashCode());
    }
}

