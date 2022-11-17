package com.example.CS3141R01Team2.Security.config;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.connector.Request;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.NullRememberMeServices;

class CustomFilterTest {
    /**
     * Method under test: default or parameterless constructor of {@link CustomFilter}
     */
    @Test
    void testConstructor() {
        assertTrue((new CustomFilter()).getRememberMeServices() instanceof NullRememberMeServices);
    }

    /**
     * Method under test: {@link CustomFilter#attemptAuthentication(HttpServletRequest, HttpServletResponse)}
     */
    @Test
    void testAttemptAuthentication() throws AuthenticationException {
        CustomFilter customFilter = new CustomFilter();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertThrows(AuthenticationServiceException.class,
                () -> customFilter.attemptAuthentication(request, new Response()));
    }

    /**
     * Method under test: {@link CustomFilter#attemptAuthentication(HttpServletRequest, HttpServletResponse)}
     */
    @Test
    void testAttemptAuthentication2() throws AuthenticationException {
        CustomFilter customFilter = new CustomFilter();
        HttpServletRequestWrapper request = new HttpServletRequestWrapper(new MockHttpServletRequest());
        assertThrows(AuthenticationServiceException.class,
                () -> customFilter.attemptAuthentication(request, new Response()));
    }

    /**
     * Method under test: {@link CustomFilter#attemptAuthentication(HttpServletRequest, HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAttemptAuthentication3() throws AuthenticationException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "javax.servlet.http.HttpServletRequest.getInputStream()" because "request" is null
        //       at com.example.CS3141R01Team2.Security.config.CustomFilter.attemptAuthentication(CustomFilter.java:29)
        //   See https://diff.blue/R013 to resolve this issue.

        CustomFilter customFilter = new CustomFilter();
        customFilter.attemptAuthentication(null, new Response());
    }

    /**
     * Method under test: {@link CustomFilter#attemptAuthentication(HttpServletRequest, HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAttemptAuthentication4() throws AuthenticationException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.apache.coyote.Request.getReadListener()" because "this.coyoteRequest" is null
        //       at org.apache.catalina.connector.InputBuffer.isBlocking(InputBuffer.java:291)
        //       at org.apache.catalina.connector.CoyoteInputStream.checkNonBlockingRead(CoyoteInputStream.java:215)
        //       at org.apache.catalina.connector.CoyoteInputStream.read(CoyoteInputStream.java:116)
        //       at com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper.ensureLoaded(ByteSourceJsonBootstrapper.java:539)
        //       at com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper.detectEncoding(ByteSourceJsonBootstrapper.java:133)
        //       at com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper.constructParser(ByteSourceJsonBootstrapper.java:256)
        //       at com.fasterxml.jackson.core.JsonFactory._createParser(JsonFactory.java:1655)
        //       at com.fasterxml.jackson.core.JsonFactory.createParser(JsonFactory.java:1083)
        //       at com.fasterxml.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:3666)
        //       at com.example.CS3141R01Team2.Security.config.CustomFilter.attemptAuthentication(CustomFilter.java:29)
        //   See https://diff.blue/R013 to resolve this issue.

        CustomFilter customFilter = new CustomFilter();
        Request request = new Request(new Connector());
        customFilter.attemptAuthentication(request, new Response());
    }

    /**
     * Method under test: {@link CustomFilter#attemptAuthentication(HttpServletRequest, HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAttemptAuthentication5() throws AuthenticationException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "javax.servlet.http.HttpServletRequest.getInputStream()" because "request" is null
        //       at com.example.CS3141R01Team2.Security.config.CustomFilter.attemptAuthentication(CustomFilter.java:29)
        //   See https://diff.blue/R013 to resolve this issue.

        CustomFilter customFilter = new CustomFilter();
        customFilter.setApplicationEventPublisher(mock(ApplicationEventPublisher.class));
        customFilter.attemptAuthentication(null, new Response());
    }
}

