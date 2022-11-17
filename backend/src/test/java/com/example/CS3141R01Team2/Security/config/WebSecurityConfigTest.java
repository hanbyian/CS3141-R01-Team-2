package com.example.CS3141R01Team2.Security.config;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.example.CS3141R01Team2.Registration.token.ConfirmationTokenRepository;
import com.example.CS3141R01Team2.Registration.token.ConfirmationTokenService;
import com.example.CS3141R01Team2.Users.UsersRepository;
import com.example.CS3141R01Team2.Users.UsersService;

import java.util.HashMap;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.cache.NullUserCache;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.accept.ContentNegotiationStrategy;

@ContextConfiguration(classes = {WebSecurityConfig.class, BCryptPasswordEncoder.class,
        AuthenticationConfiguration.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class WebSecurityConfigTest {
    @Autowired
    private ApplicationContext applicationContext;

    @MockBean
    private AuthenticationTrustResolver authenticationTrustResolver;

    @MockBean
    private ContentNegotiationStrategy contentNegotiationStrategy;

    @Autowired
    private ObjectPostProcessor<Object> objectPostProcessor;

    @MockBean
    private UsersService usersService;

    @Autowired
    private WebSecurityConfig webSecurityConfig;

    /**
     * Method under test: {@link WebSecurityConfig#configure(AuthenticationManagerBuilder)}
     */
    @Test
    void testConfigure() throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = new AuthenticationManagerBuilder(objectPostProcessor);
        webSecurityConfig.configure(authenticationManagerBuilder);
        assertTrue(authenticationManagerBuilder.isConfigured());
    }

    /**
     * Method under test: {@link WebSecurityConfig#configure(AuthenticationManagerBuilder)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConfigure2() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder.authenticationProvider(org.springframework.security.authentication.AuthenticationProvider)" because "auth" is null
        //       at com.example.CS3141R01Team2.Security.config.WebSecurityConfig.configure(WebSecurityConfig.java:60)
        //   See https://diff.blue/R013 to resolve this issue.

        webSecurityConfig.configure((AuthenticationManagerBuilder) null);
    }

    /**
     * Method under test: {@link WebSecurityConfig#configure(AuthenticationManagerBuilder)}
     */
    @Test
    void testConfigure3() throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = new AuthenticationManagerBuilder(objectPostProcessor);
        authenticationManagerBuilder
                .authenticationEventPublisher(new DefaultAuthenticationEventPublisher(mock(ApplicationEventPublisher.class)));
        webSecurityConfig.configure(authenticationManagerBuilder);
        assertTrue(authenticationManagerBuilder.isConfigured());
    }

    /**
     * Method under test: {@link WebSecurityConfig#configure(HttpSecurity)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConfigure4() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.context.ApplicationContext.getBeanNamesForType(java.lang.Class)" because "context" is null
        //       at com.example.CS3141R01Team2.Security.config.WebSecurityConfig.configure(WebSecurityConfig.java:37)
        //   See https://diff.blue/R013 to resolve this issue.

        AuthenticationManagerBuilder authenticationBuilder = new AuthenticationManagerBuilder(objectPostProcessor);
        webSecurityConfig.configure(new HttpSecurity(objectPostProcessor, authenticationBuilder, new HashMap<>()));
    }

    /**
     * Method under test: {@link WebSecurityConfig#configure(HttpSecurity)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConfigure5() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.config.annotation.web.builders.HttpSecurity.csrf()" because "http" is null
        //       at com.example.CS3141R01Team2.Security.config.WebSecurityConfig.configure(WebSecurityConfig.java:32)
        //   See https://diff.blue/R013 to resolve this issue.

        webSecurityConfig.configure((HttpSecurity) null);
    }

    /**
     * Method under test: {@link WebSecurityConfig#myAuthenticationSuccessHandler()}
     */
    @Test
    void testMyAuthenticationSuccessHandler() {
        assertTrue(webSecurityConfig.myAuthenticationSuccessHandler() instanceof MySimpleUrlAuthenticationSuccessHandler);
    }

    /**
     * Method under test: {@link WebSecurityConfig#daoAuthenticationProvider()}
     */
    @Test
    void testDaoAuthenticationProvider() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        UsersRepository usersRepository = mock(UsersRepository.class);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        UsersService usersService = new UsersService(usersRepository, bCryptPasswordEncoder,
                new ConfirmationTokenService(mock(ConfirmationTokenRepository.class)));

        DaoAuthenticationProvider actualDaoAuthenticationProviderResult = (new WebSecurityConfig(usersService,
                new BCryptPasswordEncoder())).daoAuthenticationProvider();
        assertTrue(actualDaoAuthenticationProviderResult.getUserCache() instanceof NullUserCache);
        assertTrue(actualDaoAuthenticationProviderResult.isHideUserNotFoundExceptions());
        assertFalse(actualDaoAuthenticationProviderResult.isForcePrincipalAsString());
    }

    /**
     * Method under test: {@link WebSecurityConfig#daoAuthenticationProvider()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDaoAuthenticationProvider2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: passwordEncoder cannot be null
        //       at com.example.CS3141R01Team2.Security.config.WebSecurityConfig.daoAuthenticationProvider(WebSecurityConfig.java:67)
        //   See https://diff.blue/R013 to resolve this issue.

        UsersRepository usersRepository = mock(UsersRepository.class);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        (new WebSecurityConfig(new UsersService(usersRepository, bCryptPasswordEncoder,
                new ConfirmationTokenService(mock(ConfirmationTokenRepository.class))), null)).daoAuthenticationProvider();
    }
}

