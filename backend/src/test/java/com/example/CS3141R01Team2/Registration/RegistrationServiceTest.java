package com.example.CS3141R01Team2.Registration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.CS3141R01Team2.Email.EmailSender;
import com.example.CS3141R01Team2.Registration.token.ConfirmationToken;
import com.example.CS3141R01Team2.Registration.token.ConfirmationTokenService;
import com.example.CS3141R01Team2.Users.UserRole;
import com.example.CS3141R01Team2.Users.Users;
import com.example.CS3141R01Team2.Users.UsersService;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RegistrationService.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class RegistrationServiceTest {
    @MockBean
    private ConfirmationTokenService confirmationTokenService;

    @MockBean
    private EmailSender emailSender;

    @MockBean
    private EmailValidator emailValidator;

    @Autowired
    private RegistrationService registrationService;

    @MockBean
    private UsersService usersService;

    /**
     * Method under test: {@link RegistrationService#register(RegistrationRequest)}
     */
    @Test
    void testRegister() {
        when(usersService.createUser((Users) any())).thenReturn("Create User");
        when(emailValidator.test((String) any())).thenReturn(true);
        doNothing().when(emailSender).send((String) any(), (String) any());
        assertEquals("Create User",
                registrationService.register(new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org", "Name")));
        verify(usersService).createUser((Users) any());
        verify(emailValidator).test((String) any());
        verify(emailSender).send((String) any(), (String) any());
    }

    /**
     * Method under test: {@link RegistrationService#register(RegistrationRequest)}
     */
    @Test
    void testRegister2() {
        when(usersService.createUser((Users) any())).thenReturn("Create User");
        when(emailValidator.test((String) any())).thenReturn(true);
        doThrow(new IllegalStateException()).when(emailSender).send((String) any(), (String) any());
        assertThrows(IllegalStateException.class, () -> registrationService
                .register(new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org", "Name")));
        verify(usersService).createUser((Users) any());
        verify(emailValidator).test((String) any());
        verify(emailSender).send((String) any(), (String) any());
    }

    /**
     * Method under test: {@link RegistrationService#register(RegistrationRequest)}
     */
    @Test
    void testRegister3() {
        when(usersService.createUser((Users) any())).thenReturn("Create User");
        when(emailValidator.test((String) any())).thenReturn(false);
        doNothing().when(emailSender).send((String) any(), (String) any());
        assertThrows(IllegalStateException.class, () -> registrationService
                .register(new RegistrationRequest("janedoe", "iloveyou", "jane.doe@example.org", "Name")));
        verify(emailValidator).test((String) any());
    }

    /**
     * Method under test: {@link RegistrationService#register(RegistrationRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRegister4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.example.CS3141R01Team2.Registration.RegistrationRequest.getEmail()" because "request" is null
        //       at com.example.CS3141R01Team2.Registration.RegistrationService.register(RegistrationService.java:27)
        //   See https://diff.blue/R013 to resolve this issue.

        when(usersService.createUser((Users) any())).thenReturn("Create User");
        when(emailValidator.test((String) any())).thenReturn(true);
        doNothing().when(emailSender).send((String) any(), (String) any());
        registrationService.register(null);
    }

    /**
     * Method under test: {@link RegistrationService#confirmToken(String)}
     */
    @Test
    void testConfirmToken() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setEnabled(true);
        users.setLocked(true);
        users.setName("Name");
        users.setPassword("iloveyou");
        users.setUserID(1L);
        users.setUserRole(UserRole.USER);
        users.setUsername("janedoe");

        ConfirmationToken confirmationToken = new ConfirmationToken();
        confirmationToken.setConfirmedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setExpiresAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setId(123L);
        confirmationToken.setToken("ABC123");
        confirmationToken.setUsers(users);
        Optional<ConfirmationToken> ofResult = Optional.of(confirmationToken);
        when(confirmationTokenService.getToken((String) any())).thenReturn(ofResult);
        assertThrows(IllegalStateException.class, () -> registrationService.confirmToken("ABC123"));
        verify(confirmationTokenService).getToken((String) any());
    }

    /**
     * Method under test: {@link RegistrationService#confirmToken(String)}
     */
    @Test
    void testConfirmToken2() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setEnabled(true);
        users.setLocked(true);
        users.setName("Name");
        users.setPassword("iloveyou");
        users.setUserID(1L);
        users.setUserRole(UserRole.USER);
        users.setUsername("janedoe");
        ConfirmationToken confirmationToken = mock(ConfirmationToken.class);
        when(confirmationToken.getConfirmedAt()).thenReturn(null);
        when(confirmationToken.getExpiresAt()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        doNothing().when(confirmationToken).setConfirmedAt((LocalDateTime) any());
        doNothing().when(confirmationToken).setCreatedAt((LocalDateTime) any());
        doNothing().when(confirmationToken).setExpiresAt((LocalDateTime) any());
        doNothing().when(confirmationToken).setId((Long) any());
        doNothing().when(confirmationToken).setToken((String) any());
        doNothing().when(confirmationToken).setUsers((Users) any());
        confirmationToken.setConfirmedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setExpiresAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setId(123L);
        confirmationToken.setToken("ABC123");
        confirmationToken.setUsers(users);
        Optional<ConfirmationToken> ofResult = Optional.of(confirmationToken);
        when(confirmationTokenService.getToken((String) any())).thenReturn(ofResult);
        assertThrows(IllegalStateException.class, () -> registrationService.confirmToken("ABC123"));
        verify(confirmationTokenService).getToken((String) any());
        verify(confirmationToken).getConfirmedAt();
        verify(confirmationToken).getExpiresAt();
        verify(confirmationToken).setConfirmedAt((LocalDateTime) any());
        verify(confirmationToken).setCreatedAt((LocalDateTime) any());
        verify(confirmationToken).setExpiresAt((LocalDateTime) any());
        verify(confirmationToken).setId((Long) any());
        verify(confirmationToken).setToken((String) any());
        verify(confirmationToken).setUsers((Users) any());
    }

    /**
     * Method under test: {@link RegistrationService#confirmToken(String)}
     */
    @Test
    void testConfirmToken3() {
        when(confirmationTokenService.getToken((String) any())).thenReturn(Optional.empty());

        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setEnabled(true);
        users.setLocked(true);
        users.setName("Name");
        users.setPassword("iloveyou");
        users.setUserID(1L);
        users.setUserRole(UserRole.USER);
        users.setUsername("janedoe");
        ConfirmationToken confirmationToken = mock(ConfirmationToken.class);
        when(confirmationToken.getConfirmedAt()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        when(confirmationToken.getExpiresAt()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        doNothing().when(confirmationToken).setConfirmedAt((LocalDateTime) any());
        doNothing().when(confirmationToken).setCreatedAt((LocalDateTime) any());
        doNothing().when(confirmationToken).setExpiresAt((LocalDateTime) any());
        doNothing().when(confirmationToken).setId((Long) any());
        doNothing().when(confirmationToken).setToken((String) any());
        doNothing().when(confirmationToken).setUsers((Users) any());
        confirmationToken.setConfirmedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setExpiresAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setId(123L);
        confirmationToken.setToken("ABC123");
        confirmationToken.setUsers(users);
        assertThrows(IllegalStateException.class, () -> registrationService.confirmToken("ABC123"));
        verify(confirmationTokenService).getToken((String) any());
        verify(confirmationToken).setConfirmedAt((LocalDateTime) any());
        verify(confirmationToken).setCreatedAt((LocalDateTime) any());
        verify(confirmationToken).setExpiresAt((LocalDateTime) any());
        verify(confirmationToken).setId((Long) any());
        verify(confirmationToken).setToken((String) any());
        verify(confirmationToken).setUsers((Users) any());
    }
}

