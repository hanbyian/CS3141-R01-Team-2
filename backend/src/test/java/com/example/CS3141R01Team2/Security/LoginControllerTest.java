package com.example.CS3141R01Team2.Security;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.security.access.intercept.RunAsImplAuthenticationProvider;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

class LoginControllerTest {
    /**
     * Method under test: {@link LoginController#loginUser(LoginRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLoginUser() throws Exception {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class com.example.CS3141R01Team2.Security.LoginRequest]; nested exception is com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.example.CS3141R01Team2.Security.LoginRequest` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
        //    at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 1, column: 2]
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:707)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:790)
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.example.CS3141R01Team2.Security.LoginRequest` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
        //    at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 1, column: 2]
        //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:67)
        //       at com.fasterxml.jackson.databind.DeserializationContext.reportBadDefinition(DeserializationContext.java:1904)
        //       at com.fasterxml.jackson.databind.DatabindContext.reportBadDefinition(DatabindContext.java:400)
        //       at com.fasterxml.jackson.databind.DeserializationContext.handleMissingInstantiator(DeserializationContext.java:1349)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializerBase.deserializeFromObjectUsingNonDefault(BeanDeserializerBase.java:1415)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserializeFromObject(BeanDeserializer.java:352)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserialize(BeanDeserializer.java:185)
        //       at com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.readRootValue(DefaultDeserializationContext.java:323)
        //       at com.fasterxml.jackson.databind.ObjectMapper._readMapAndClose(ObjectMapper.java:4674)
        //       at com.fasterxml.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:3682)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:707)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:790)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.security.authentication.ProviderNotFoundException: No AuthenticationProvider found for org.springframework.security.authentication.UsernamePasswordAuthenticationToken
        //       at com.example.CS3141R01Team2.Security.LoginController.loginUser(LoginController.java:38)
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AuthenticationProvider> authenticationProviderList = new ArrayList<>();
        authenticationProviderList.add(new RunAsImplAuthenticationProvider());
        LoginController loginController = new LoginController(new ProviderManager(authenticationProviderList));
        loginController.loginUser(new LoginRequest("janedoe", "iloveyou"));
    }

    /**
     * Method under test: {@link LoginController#loginUser(LoginRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLoginUser2() throws Exception {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class com.example.CS3141R01Team2.Security.LoginRequest]; nested exception is com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.example.CS3141R01Team2.Security.LoginRequest` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
        //    at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 1, column: 2]
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:707)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:790)
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.example.CS3141R01Team2.Security.LoginRequest` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
        //    at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 1, column: 2]
        //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:67)
        //       at com.fasterxml.jackson.databind.DeserializationContext.reportBadDefinition(DeserializationContext.java:1904)
        //       at com.fasterxml.jackson.databind.DatabindContext.reportBadDefinition(DatabindContext.java:400)
        //       at com.fasterxml.jackson.databind.DeserializationContext.handleMissingInstantiator(DeserializationContext.java:1349)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializerBase.deserializeFromObjectUsingNonDefault(BeanDeserializerBase.java:1415)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserializeFromObject(BeanDeserializer.java:352)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserialize(BeanDeserializer.java:185)
        //       at com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.readRootValue(DefaultDeserializationContext.java:323)
        //       at com.fasterxml.jackson.databind.ObjectMapper._readMapAndClose(ObjectMapper.java:4674)
        //       at com.fasterxml.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:3682)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:707)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:790)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.security.authentication.ProviderNotFoundException: No AuthenticationProvider found for org.springframework.security.authentication.UsernamePasswordAuthenticationToken
        //       at com.example.CS3141R01Team2.Security.LoginController.loginUser(LoginController.java:38)
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AuthenticationProvider> authenticationProviderList = new ArrayList<>();
        authenticationProviderList.add(new RunAsImplAuthenticationProvider());
        LoginController loginController = new LoginController(new ProviderManager(authenticationProviderList));
        LoginRequest loginRequest = mock(LoginRequest.class);
        when(loginRequest.getPassword()).thenReturn("iloveyou");
        when(loginRequest.getUsername()).thenReturn("janedoe");
        loginController.loginUser(loginRequest);
    }

    /**
     * Method under test: {@link LoginController#loginUser(LoginRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLoginUser3() throws Exception {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class com.example.CS3141R01Team2.Security.LoginRequest]; nested exception is com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.example.CS3141R01Team2.Security.LoginRequest` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
        //    at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 1, column: 2]
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:707)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:790)
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.example.CS3141R01Team2.Security.LoginRequest` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
        //    at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 1, column: 2]
        //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:67)
        //       at com.fasterxml.jackson.databind.DeserializationContext.reportBadDefinition(DeserializationContext.java:1904)
        //       at com.fasterxml.jackson.databind.DatabindContext.reportBadDefinition(DatabindContext.java:400)
        //       at com.fasterxml.jackson.databind.DeserializationContext.handleMissingInstantiator(DeserializationContext.java:1349)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializerBase.deserializeFromObjectUsingNonDefault(BeanDeserializerBase.java:1415)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserializeFromObject(BeanDeserializer.java:352)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserialize(BeanDeserializer.java:185)
        //       at com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.readRootValue(DefaultDeserializationContext.java:323)
        //       at com.fasterxml.jackson.databind.ObjectMapper._readMapAndClose(ObjectMapper.java:4674)
        //       at com.fasterxml.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:3682)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:707)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:790)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.security.authentication.InternalAuthenticationServiceException: Cannot invoke "org.springframework.security.core.userdetails.UserDetailsService.loadUserByUsername(String)" because the return value of "org.springframework.security.authentication.dao.DaoAuthenticationProvider.getUserDetailsService()" is null
        //       at com.example.CS3141R01Team2.Security.LoginController.loginUser(LoginController.java:38)
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.core.userdetails.UserDetailsService.loadUserByUsername(String)" because the return value of "org.springframework.security.authentication.dao.DaoAuthenticationProvider.getUserDetailsService()" is null
        //       at com.example.CS3141R01Team2.Security.LoginController.loginUser(LoginController.java:38)
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AuthenticationProvider> authenticationProviderList = new ArrayList<>();
        authenticationProviderList.add(new DaoAuthenticationProvider());
        LoginController loginController = new LoginController(new ProviderManager(authenticationProviderList));
        LoginRequest loginRequest = mock(LoginRequest.class);
        when(loginRequest.getPassword()).thenReturn("iloveyou");
        when(loginRequest.getUsername()).thenReturn("janedoe");
        loginController.loginUser(loginRequest);
    }

    /**
     * Method under test: {@link LoginController#loginUser(LoginRequest)}
     */
    @Test
    void testLoginUser4() throws Exception {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class com.example.CS3141R01Team2.Security.LoginRequest]; nested exception is com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.example.CS3141R01Team2.Security.LoginRequest` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
        //    at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 1, column: 2]
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:707)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:790)
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.example.CS3141R01Team2.Security.LoginRequest` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
        //    at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 1, column: 2]
        //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:67)
        //       at com.fasterxml.jackson.databind.DeserializationContext.reportBadDefinition(DeserializationContext.java:1904)
        //       at com.fasterxml.jackson.databind.DatabindContext.reportBadDefinition(DatabindContext.java:400)
        //       at com.fasterxml.jackson.databind.DeserializationContext.handleMissingInstantiator(DeserializationContext.java:1349)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializerBase.deserializeFromObjectUsingNonDefault(BeanDeserializerBase.java:1415)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserializeFromObject(BeanDeserializer.java:352)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserialize(BeanDeserializer.java:185)
        //       at com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.readRootValue(DefaultDeserializationContext.java:323)
        //       at com.fasterxml.jackson.databind.ObjectMapper._readMapAndClose(ObjectMapper.java:4674)
        //       at com.fasterxml.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:3682)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:707)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:790)
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AuthenticationProvider> authenticationProviderList = new ArrayList<>();
        authenticationProviderList.add(new RunAsImplAuthenticationProvider());
        LoginController loginController = new LoginController(new ProviderManager(authenticationProviderList));
        LoginRequest loginRequest = mock(LoginRequest.class);
        when(loginRequest.getPassword()).thenThrow(new BadCredentialsException("Msg"));
        when(loginRequest.getUsername()).thenThrow(new BadCredentialsException("Msg"));
        assertThrows(Exception.class, () -> loginController.loginUser(loginRequest));
        verify(loginRequest).getUsername();
    }
}

