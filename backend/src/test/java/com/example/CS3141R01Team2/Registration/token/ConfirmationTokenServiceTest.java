package com.example.CS3141R01Team2.Registration.token;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.CS3141R01Team2.Users.UserRole;
import com.example.CS3141R01Team2.Users.Users;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ConfirmationTokenService.class})
@ExtendWith(SpringExtension.class)
class ConfirmationTokenServiceTest {
    @MockBean
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    /**
     * Method under test: {@link ConfirmationTokenService#saveConfirmationToken(ConfirmationToken)}
     */
    @Test
    void testSaveConfirmationToken() {
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
        when(confirmationTokenRepository.save((ConfirmationToken) any())).thenReturn(confirmationToken);

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setEnabled(true);
        users1.setLocked(true);
        users1.setName("Name");
        users1.setPassword("iloveyou");
        users1.setUserID(1L);
        users1.setUserRole(UserRole.USER);
        users1.setUsername("janedoe");

        ConfirmationToken confirmationToken1 = new ConfirmationToken();
        confirmationToken1.setConfirmedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken1.setExpiresAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken1.setId(123L);
        confirmationToken1.setToken("ABC123");
        confirmationToken1.setUsers(users1);
        confirmationTokenService.saveConfirmationToken(confirmationToken1);
        verify(confirmationTokenRepository).save((ConfirmationToken) any());
        assertEquals(users, confirmationToken1.getUsers());
        assertEquals("01:01", confirmationToken1.getConfirmedAt().toLocalTime().toString());
        assertEquals(123L, confirmationToken1.getId().longValue());
        assertEquals("ABC123", confirmationToken1.getToken());
        assertEquals("0001-01-01", confirmationToken1.getCreatedAt().toLocalDate().toString());
        assertEquals("0001-01-01", confirmationToken1.getExpiresAt().toLocalDate().toString());
    }

    /**
     * Method under test: {@link ConfirmationTokenService#setConfirmedAt(String)}
     */
    @Test
    void testSetConfirmedAt() {
        when(confirmationTokenRepository.updateConfirmedAt((String) any(), (LocalDateTime) any())).thenReturn(1);
        assertEquals(1, confirmationTokenService.setConfirmedAt("ABC123"));
        verify(confirmationTokenRepository).updateConfirmedAt((String) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link ConfirmationTokenService#getToken(String)}
     */
    @Test
    void testGetToken() {
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
        when(confirmationTokenRepository.findByToken((String) any())).thenReturn(ofResult);
        Optional<ConfirmationToken> actualToken = confirmationTokenService.getToken("ABC123");
        assertSame(ofResult, actualToken);
        assertTrue(actualToken.isPresent());
        verify(confirmationTokenRepository).findByToken((String) any());
    }
}

