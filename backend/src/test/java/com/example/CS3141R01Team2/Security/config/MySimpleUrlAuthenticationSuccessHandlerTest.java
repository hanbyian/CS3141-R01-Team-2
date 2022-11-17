package com.example.CS3141R01Team2.Security.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.beans.PropertyChangeListener;
import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import org.apache.catalina.session.PersistentManager;
import org.apache.catalina.session.StandardSession;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.DelegatingServletInputStream;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;

class MySimpleUrlAuthenticationSuccessHandlerTest {
    /**
     * Method under test: {@link MySimpleUrlAuthenticationSuccessHandler#onAuthenticationSuccess(HttpServletRequest, HttpServletResponse, Authentication)}
     */
    @Test
    void testOnAuthenticationSuccess() throws IOException, ServletException {
        MySimpleUrlAuthenticationSuccessHandler mySimpleUrlAuthenticationSuccessHandler = new MySimpleUrlAuthenticationSuccessHandler();
        MockHttpServletRequest request = new MockHttpServletRequest();
        Response response = new Response();
        assertThrows(IllegalStateException.class, () -> mySimpleUrlAuthenticationSuccessHandler
                .onAuthenticationSuccess(request, response, new TestingAuthenticationToken("Principal", "Credentials")));
    }

    /**
     * Method under test: {@link MySimpleUrlAuthenticationSuccessHandler#onAuthenticationSuccess(HttpServletRequest, HttpServletResponse, Authentication)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testOnAuthenticationSuccess2() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.core.Authentication.getAuthorities()" because "authentication" is null
        //       at com.example.CS3141R01Team2.Security.config.MySimpleUrlAuthenticationSuccessHandler.determineTargetURL(MySimpleUrlAuthenticationSuccessHandler.java:61)
        //       at com.example.CS3141R01Team2.Security.config.MySimpleUrlAuthenticationSuccessHandler.handle(MySimpleUrlAuthenticationSuccessHandler.java:43)
        //       at com.example.CS3141R01Team2.Security.config.MySimpleUrlAuthenticationSuccessHandler.onAuthenticationSuccess(MySimpleUrlAuthenticationSuccessHandler.java:35)
        //   See https://diff.blue/R013 to resolve this issue.

        MySimpleUrlAuthenticationSuccessHandler mySimpleUrlAuthenticationSuccessHandler = new MySimpleUrlAuthenticationSuccessHandler();
        MockHttpServletRequest request = new MockHttpServletRequest();
        mySimpleUrlAuthenticationSuccessHandler.onAuthenticationSuccess(request, new Response(), null);
    }

    /**
     * Method under test: {@link MySimpleUrlAuthenticationSuccessHandler#onAuthenticationSuccess(HttpServletRequest, HttpServletResponse, Authentication)}
     */
    @Test
    void testOnAuthenticationSuccess3() throws IOException, ServletException {
        MySimpleUrlAuthenticationSuccessHandler mySimpleUrlAuthenticationSuccessHandler = new MySimpleUrlAuthenticationSuccessHandler();
        MockHttpServletRequest request = new MockHttpServletRequest();
        Response response = new Response();
        assertThrows(IllegalStateException.class,
                () -> mySimpleUrlAuthenticationSuccessHandler.onAuthenticationSuccess(request, response,
                        new TestingAuthenticationToken("Principal", "Credentials", "JaneDoe")));
    }

    /**
     * Method under test: {@link MySimpleUrlAuthenticationSuccessHandler#handle(HttpServletRequest, HttpServletResponse, Authentication)}
     */
    @Test
    void testHandle() throws IOException {
        MySimpleUrlAuthenticationSuccessHandler mySimpleUrlAuthenticationSuccessHandler = new MySimpleUrlAuthenticationSuccessHandler();
        MockHttpServletRequest request = new MockHttpServletRequest();
        Response response = new Response();
        assertThrows(IllegalStateException.class, () -> mySimpleUrlAuthenticationSuccessHandler.handle(request, response,
                new TestingAuthenticationToken("Principal", "Credentials")));
    }

    /**
     * Method under test: {@link MySimpleUrlAuthenticationSuccessHandler#handle(HttpServletRequest, HttpServletResponse, Authentication)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandle2() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.core.Authentication.getAuthorities()" because "authentication" is null
        //       at com.example.CS3141R01Team2.Security.config.MySimpleUrlAuthenticationSuccessHandler.determineTargetURL(MySimpleUrlAuthenticationSuccessHandler.java:61)
        //       at com.example.CS3141R01Team2.Security.config.MySimpleUrlAuthenticationSuccessHandler.handle(MySimpleUrlAuthenticationSuccessHandler.java:43)
        //   See https://diff.blue/R013 to resolve this issue.

        MySimpleUrlAuthenticationSuccessHandler mySimpleUrlAuthenticationSuccessHandler = new MySimpleUrlAuthenticationSuccessHandler();
        MockHttpServletRequest request = new MockHttpServletRequest();
        mySimpleUrlAuthenticationSuccessHandler.handle(request, new Response(), null);
    }

    /**
     * Method under test: {@link MySimpleUrlAuthenticationSuccessHandler#handle(HttpServletRequest, HttpServletResponse, Authentication)}
     */
    @Test
    void testHandle3() throws IOException {
        MySimpleUrlAuthenticationSuccessHandler mySimpleUrlAuthenticationSuccessHandler = new MySimpleUrlAuthenticationSuccessHandler();
        MockHttpServletRequest request = new MockHttpServletRequest();
        Response response = new Response();
        assertThrows(IllegalStateException.class, () -> mySimpleUrlAuthenticationSuccessHandler.handle(request, response,
                new TestingAuthenticationToken("Principal", "Credentials", "JaneDoe")));
    }

    /**
     * Method under test: {@link MySimpleUrlAuthenticationSuccessHandler#determineTargetURL(Authentication)}
     */
    @Test
    void testDetermineTargetURL() {
        MySimpleUrlAuthenticationSuccessHandler mySimpleUrlAuthenticationSuccessHandler = new MySimpleUrlAuthenticationSuccessHandler();
        assertThrows(IllegalStateException.class, () -> mySimpleUrlAuthenticationSuccessHandler
                .determineTargetURL(new TestingAuthenticationToken("Principal", "Credentials")));
    }

    /**
     * Method under test: {@link MySimpleUrlAuthenticationSuccessHandler#determineTargetURL(Authentication)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDetermineTargetURL2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.core.Authentication.getAuthorities()" because "authentication" is null
        //       at com.example.CS3141R01Team2.Security.config.MySimpleUrlAuthenticationSuccessHandler.determineTargetURL(MySimpleUrlAuthenticationSuccessHandler.java:61)
        //   See https://diff.blue/R013 to resolve this issue.

        (new MySimpleUrlAuthenticationSuccessHandler()).determineTargetURL(null);
    }

    /**
     * Method under test: {@link MySimpleUrlAuthenticationSuccessHandler#determineTargetURL(Authentication)}
     */
    @Test
    void testDetermineTargetURL3() {
        MySimpleUrlAuthenticationSuccessHandler mySimpleUrlAuthenticationSuccessHandler = new MySimpleUrlAuthenticationSuccessHandler();
        assertThrows(IllegalStateException.class, () -> mySimpleUrlAuthenticationSuccessHandler
                .determineTargetURL(new TestingAuthenticationToken("Principal", "Credentials", "JaneDoe")));
    }

    /**
     * Method under test: {@link MySimpleUrlAuthenticationSuccessHandler#determineTargetURL(Authentication)}
     */
    @Test
    void testDetermineTargetURL4() {
        MySimpleUrlAuthenticationSuccessHandler mySimpleUrlAuthenticationSuccessHandler = new MySimpleUrlAuthenticationSuccessHandler();
        assertEquals("https://www.google.com", mySimpleUrlAuthenticationSuccessHandler
                .determineTargetURL(new TestingAuthenticationToken("Principal", "Credentials", "USER")));
    }

    /**
     * Method under test: {@link MySimpleUrlAuthenticationSuccessHandler#clearAuthenticationAttributes(HttpServletRequest)}
     */
    @Test
    void testClearAuthenticationAttributes() {
        MySimpleUrlAuthenticationSuccessHandler mySimpleUrlAuthenticationSuccessHandler = new MySimpleUrlAuthenticationSuccessHandler();
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mySimpleUrlAuthenticationSuccessHandler.clearAuthenticationAttributes(mockHttpServletRequest);
        assertTrue(mockHttpServletRequest.isRequestedSessionIdValid());
        assertFalse(mockHttpServletRequest.isRequestedSessionIdFromUrl());
        assertTrue(mockHttpServletRequest.isRequestedSessionIdFromCookie());
        assertFalse(mockHttpServletRequest.isAsyncSupported());
        assertFalse(mockHttpServletRequest.isAsyncStarted());
        assertTrue(mockHttpServletRequest.isActive());
        assertTrue(mockHttpServletRequest.getSession() instanceof MockHttpSession);
        assertEquals("", mockHttpServletRequest.getServletPath());
        assertEquals(80, mockHttpServletRequest.getServerPort());
        assertEquals("localhost", mockHttpServletRequest.getServerName());
        assertEquals("http", mockHttpServletRequest.getScheme());
        assertEquals("", mockHttpServletRequest.getRequestURI());
        assertEquals(80, mockHttpServletRequest.getRemotePort());
        assertEquals("localhost", mockHttpServletRequest.getRemoteHost());
        assertEquals("HTTP/1.1", mockHttpServletRequest.getProtocol());
        assertEquals("", mockHttpServletRequest.getMethod());
        assertEquals(80, mockHttpServletRequest.getLocalPort());
        assertEquals("localhost", mockHttpServletRequest.getLocalName());
        assertTrue(mockHttpServletRequest.getInputStream() instanceof DelegatingServletInputStream);
        assertEquals(DispatcherType.REQUEST, mockHttpServletRequest.getDispatcherType());
        assertEquals("", mockHttpServletRequest.getContextPath());
        assertEquals(-1L, mockHttpServletRequest.getContentLengthLong());
    }

    /**
     * Method under test: {@link MySimpleUrlAuthenticationSuccessHandler#clearAuthenticationAttributes(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testClearAuthenticationAttributes2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "javax.servlet.http.HttpServletRequest.getSession(boolean)" because "request" is null
        //       at com.example.CS3141R01Team2.Security.config.MySimpleUrlAuthenticationSuccessHandler.clearAuthenticationAttributes(MySimpleUrlAuthenticationSuccessHandler.java:72)
        //   See https://diff.blue/R013 to resolve this issue.

        (new MySimpleUrlAuthenticationSuccessHandler()).clearAuthenticationAttributes(null);
    }

    /**
     * Method under test: {@link MySimpleUrlAuthenticationSuccessHandler#clearAuthenticationAttributes(HttpServletRequest)}
     */
    @Test
    void testClearAuthenticationAttributes3() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        MySimpleUrlAuthenticationSuccessHandler mySimpleUrlAuthenticationSuccessHandler = new MySimpleUrlAuthenticationSuccessHandler();

        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setSession(new MockHttpSession());
        mySimpleUrlAuthenticationSuccessHandler.clearAuthenticationAttributes(mockHttpServletRequest);
    }

    /**
     * Method under test: {@link MySimpleUrlAuthenticationSuccessHandler#clearAuthenticationAttributes(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testClearAuthenticationAttributes4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalStateException: removeAttribute: Session already invalidated
        //       at org.apache.catalina.session.StandardSession.removeAttribute(StandardSession.java:1333)
        //       at org.apache.catalina.session.StandardSession.removeAttribute(StandardSession.java:1307)
        //       at com.example.CS3141R01Team2.Security.config.MySimpleUrlAuthenticationSuccessHandler.clearAuthenticationAttributes(MySimpleUrlAuthenticationSuccessHandler.java:77)
        //   See https://diff.blue/R013 to resolve this issue.

        MySimpleUrlAuthenticationSuccessHandler mySimpleUrlAuthenticationSuccessHandler = new MySimpleUrlAuthenticationSuccessHandler();

        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setSession(new StandardSession(new PersistentManager()));
        mySimpleUrlAuthenticationSuccessHandler.clearAuthenticationAttributes(mockHttpServletRequest);
    }

    /**
     * Method under test: {@link MySimpleUrlAuthenticationSuccessHandler#clearAuthenticationAttributes(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testClearAuthenticationAttributes5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalStateException: removeAttribute: Session already invalidated
        //       at org.apache.catalina.session.StandardSession.removeAttribute(StandardSession.java:1333)
        //       at org.apache.catalina.session.StandardSession.removeAttribute(StandardSession.java:1307)
        //       at com.example.CS3141R01Team2.Security.config.MySimpleUrlAuthenticationSuccessHandler.clearAuthenticationAttributes(MySimpleUrlAuthenticationSuccessHandler.java:77)
        //   See https://diff.blue/R013 to resolve this issue.

        MySimpleUrlAuthenticationSuccessHandler mySimpleUrlAuthenticationSuccessHandler = new MySimpleUrlAuthenticationSuccessHandler();

        PersistentManager persistentManager = new PersistentManager();
        persistentManager.addPropertyChangeListener(mock(PropertyChangeListener.class));
        StandardSession session = new StandardSession(persistentManager);

        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setSession(session);
        mySimpleUrlAuthenticationSuccessHandler.clearAuthenticationAttributes(mockHttpServletRequest);
    }

    /**
     * Method under test: {@link MySimpleUrlAuthenticationSuccessHandler#clearAuthenticationAttributes(HttpServletRequest)}
     */
    @Test
    void testClearAuthenticationAttributes6() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        MySimpleUrlAuthenticationSuccessHandler mySimpleUrlAuthenticationSuccessHandler = new MySimpleUrlAuthenticationSuccessHandler();

        StandardSession standardSession = new StandardSession(new PersistentManager());
        standardSession.setValid(true);

        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setSession(standardSession);
        mySimpleUrlAuthenticationSuccessHandler.clearAuthenticationAttributes(mockHttpServletRequest);
    }
}

