package com.example.CS3141R01Team2.Security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LoginRequestTest {
    /**
     * Method under test: {@link LoginRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new LoginRequest("janedoe", "iloveyou")).canEqual("Other"));
    }

    /**
     * Method under test: {@link LoginRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        LoginRequest loginRequest = new LoginRequest("janedoe", "iloveyou");
        assertTrue(loginRequest.canEqual(new LoginRequest("janedoe", "iloveyou")));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link LoginRequest#LoginRequest(String, String)}
     *   <li>{@link LoginRequest#toString()}
     *   <li>{@link LoginRequest#getPassword()}
     *   <li>{@link LoginRequest#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        LoginRequest actualLoginRequest = new LoginRequest("janedoe", "iloveyou");
        String actualToStringResult = actualLoginRequest.toString();
        assertEquals("iloveyou", actualLoginRequest.getPassword());
        assertEquals("janedoe", actualLoginRequest.getUsername());
        assertEquals("LoginRequest(username=janedoe, password=iloveyou)", actualToStringResult);
    }

    /**
     * Method under test: {@link LoginRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new LoginRequest("janedoe", "iloveyou"), null);
        assertNotEquals(new LoginRequest("janedoe", "iloveyou"), "Different type to LoginRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link LoginRequest#equals(Object)}
     *   <li>{@link LoginRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        LoginRequest loginRequest = new LoginRequest("janedoe", "iloveyou");
        assertEquals(loginRequest, loginRequest);
        int expectedHashCodeResult = loginRequest.hashCode();
        assertEquals(expectedHashCodeResult, loginRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link LoginRequest#equals(Object)}
     *   <li>{@link LoginRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        LoginRequest loginRequest = new LoginRequest("janedoe", "iloveyou");
        LoginRequest loginRequest1 = new LoginRequest("janedoe", "iloveyou");

        assertEquals(loginRequest, loginRequest1);
        int expectedHashCodeResult = loginRequest.hashCode();
        assertEquals(expectedHashCodeResult, loginRequest1.hashCode());
    }

    /**
     * Method under test: {@link LoginRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        LoginRequest loginRequest = new LoginRequest("iloveyou", "iloveyou");
        assertNotEquals(loginRequest, new LoginRequest("janedoe", "iloveyou"));
    }

    /**
     * Method under test: {@link LoginRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        LoginRequest loginRequest = new LoginRequest(null, "iloveyou");
        assertNotEquals(loginRequest, new LoginRequest("janedoe", "iloveyou"));
    }

    /**
     * Method under test: {@link LoginRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        LoginRequest loginRequest = new LoginRequest("janedoe", "janedoe");
        assertNotEquals(loginRequest, new LoginRequest("janedoe", "iloveyou"));
    }

    /**
     * Method under test: {@link LoginRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        LoginRequest loginRequest = new LoginRequest("janedoe", null);
        assertNotEquals(loginRequest, new LoginRequest("janedoe", "iloveyou"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link LoginRequest#equals(Object)}
     *   <li>{@link LoginRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals8() {
        LoginRequest loginRequest = new LoginRequest(null, "iloveyou");
        LoginRequest loginRequest1 = new LoginRequest(null, "iloveyou");

        assertEquals(loginRequest, loginRequest1);
        int expectedHashCodeResult = loginRequest.hashCode();
        assertEquals(expectedHashCodeResult, loginRequest1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link LoginRequest#equals(Object)}
     *   <li>{@link LoginRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals9() {
        LoginRequest loginRequest = new LoginRequest("janedoe", null);
        LoginRequest loginRequest1 = new LoginRequest("janedoe", null);

        assertEquals(loginRequest, loginRequest1);
        int expectedHashCodeResult = loginRequest.hashCode();
        assertEquals(expectedHashCodeResult, loginRequest1.hashCode());
    }
}

