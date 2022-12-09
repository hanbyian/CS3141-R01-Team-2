package com.example.CS3141R01Team2.Users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.CS3141R01Team2.Registration.token.ConfirmationTokenService;
import com.example.CS3141R01Team2.StudySet.StudySet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UsersService.class, BCryptPasswordEncoder.class})
@ExtendWith(SpringExtension.class)
class UsersServiceTest {
    @MockBean
    private ConfirmationTokenService confirmationTokenService;

    @MockBean
    private UsersRepository usersRepository;

    @Autowired
    private UsersService usersService;

    /**
     * Method under test: {@link UsersService#showUsers()}
     */
    @Test
    void testShowUsers() {
        ArrayList<ArrayList<?>> arrayListList = new ArrayList<>();
        when((List<ArrayList<?>>) usersRepository.findAllUsers()).thenReturn(arrayListList);
        List<ArrayList<?>> actualShowUsersResult = usersService.showUsers();
        assertSame(arrayListList, actualShowUsersResult);
        assertTrue(actualShowUsersResult.isEmpty());
        verify(usersRepository).findAllUsers();
    }

    /**
     * Method under test: {@link UsersService#showUsers()}
     */
    @Test
    void testShowUsers2() {
        when((List<ArrayList<?>>) usersRepository.findAllUsers()).thenThrow(new IllegalStateException());
        assertThrows(IllegalStateException.class, () -> usersService.showUsers());
        verify(usersRepository).findAllUsers();
    }

    /**
     * Method under test: {@link UsersService#createUser(Users)}
     */
    @Test
    void testCreateUser() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setEnabled(true);
        users.setLocked(true);
        users.setName("Name");
        users.setPassword("iloveyou");
        users.setStudySets(new ArrayList<>());
        users.setUserID(1L);
        users.setUserRole(UserRole.USER);
        users.setUsername("janedoe");

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setEnabled(true);
        users1.setLocked(true);
        users1.setName("Name");
        users1.setPassword("iloveyou");
        users1.setStudySets(new ArrayList<>());
        users1.setUserID(1L);
        users1.setUserRole(UserRole.USER);
        users1.setUsername("janedoe");
        Optional<Users> ofResult = Optional.of(users1);

        Users users2 = new Users();
        users2.setEmail("jane.doe@example.org");
        users2.setEnabled(true);
        users2.setLocked(true);
        users2.setName("Name");
        users2.setPassword("iloveyou");
        users2.setStudySets(new ArrayList<>());
        users2.setUserID(1L);
        users2.setUserRole(UserRole.USER);
        users2.setUsername("janedoe");
        Optional<Users> ofResult1 = Optional.of(users2);
        when(usersRepository.save((Users) any())).thenReturn(users);
        when(usersRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(usersRepository.findByUsername((String) any())).thenReturn(ofResult1);

        Users users3 = new Users();
        users3.setEmail("jane.doe@example.org");
        users3.setEnabled(true);
        users3.setLocked(true);
        users3.setName("Name");
        users3.setPassword("iloveyou");
        users3.setStudySets(new ArrayList<>());
        users3.setUserID(1L);
        users3.setUserRole(UserRole.USER);
        users3.setUsername("janedoe");
        assertThrows(IllegalStateException.class, () -> usersService.createUser(users3));
        verify(usersRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UsersService#createUser(Users)}
     */
    @Test
    void testCreateUser2() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setEnabled(true);
        users.setLocked(true);
        users.setName("Name");
        users.setPassword("iloveyou");
        users.setStudySets(new ArrayList<>());
        users.setUserID(1L);
        users.setUserRole(UserRole.USER);
        users.setUsername("janedoe");

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setEnabled(true);
        users1.setLocked(true);
        users1.setName("Name");
        users1.setPassword("iloveyou");
        users1.setStudySets(new ArrayList<>());
        users1.setUserID(1L);
        users1.setUserRole(UserRole.USER);
        users1.setUsername("janedoe");
        Optional<Users> ofResult = Optional.of(users1);
        Users users2 = mock(Users.class);
        when(users2.getEnabled()).thenReturn(false);
        doNothing().when(users2).setEmail((String) any());
        doNothing().when(users2).setEnabled((Boolean) any());
        doNothing().when(users2).setLocked((Boolean) any());
        doNothing().when(users2).setName((String) any());
        doNothing().when(users2).setPassword((String) any());
        doNothing().when(users2).setStudySets((List<StudySet>) any());
        doNothing().when(users2).setUserID((Long) any());
        doNothing().when(users2).setUserRole((UserRole) any());
        doNothing().when(users2).setUsername((String) any());
        users2.setEmail("jane.doe@example.org");
        users2.setEnabled(true);
        users2.setLocked(true);
        users2.setName("Name");
        users2.setPassword("iloveyou");
        users2.setStudySets(new ArrayList<>());
        users2.setUserID(1L);
        users2.setUserRole(UserRole.USER);
        users2.setUsername("janedoe");
        Optional<Users> ofResult1 = Optional.of(users2);
        when(usersRepository.save((Users) any())).thenReturn(users);
        when(usersRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(usersRepository.findByUsername((String) any())).thenReturn(ofResult1);

        Users users3 = new Users();
        users3.setEmail("jane.doe@example.org");
        users3.setEnabled(true);
        users3.setLocked(true);
        users3.setName("Name");
        users3.setPassword("iloveyou");
        users3.setStudySets(new ArrayList<>());
        users3.setUserID(1L);
        users3.setUserRole(UserRole.USER);
        users3.setUsername("janedoe");
        assertThrows(IllegalStateException.class, () -> usersService.createUser(users3));
        verify(usersRepository).findByEmail((String) any());
        verify(usersRepository).findByUsername((String) any());
        verify(users2).getEnabled();
        verify(users2).setEmail((String) any());
        verify(users2).setEnabled((Boolean) any());
        verify(users2).setLocked((Boolean) any());
        verify(users2).setName((String) any());
        verify(users2).setPassword((String) any());
        verify(users2).setStudySets((List<StudySet>) any());
        verify(users2).setUserID((Long) any());
        verify(users2).setUserRole((UserRole) any());
        verify(users2).setUsername((String) any());
    }

    /**
     * Method under test: {@link UsersService#createUser(Users)}
     */
    @Test
    void testCreateUser3() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setEnabled(true);
        users.setLocked(true);
        users.setName("Name");
        users.setPassword("iloveyou");
        users.setStudySets(new ArrayList<>());
        users.setUserID(1L);
        users.setUserRole(UserRole.USER);
        users.setUsername("janedoe");

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setEnabled(true);
        users1.setLocked(true);
        users1.setName("Name");
        users1.setPassword("iloveyou");
        users1.setStudySets(new ArrayList<>());
        users1.setUserID(1L);
        users1.setUserRole(UserRole.USER);
        users1.setUsername("janedoe");
        Optional<Users> ofResult = Optional.of(users1);
        when(usersRepository.save((Users) any())).thenReturn(users);
        when(usersRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(usersRepository.findByUsername((String) any())).thenReturn(Optional.empty());
        Users users2 = mock(Users.class);
        when(users2.getEnabled()).thenReturn(true);
        doNothing().when(users2).setEmail((String) any());
        doNothing().when(users2).setEnabled((Boolean) any());
        doNothing().when(users2).setLocked((Boolean) any());
        doNothing().when(users2).setName((String) any());
        doNothing().when(users2).setPassword((String) any());
        doNothing().when(users2).setStudySets((List<StudySet>) any());
        doNothing().when(users2).setUserID((Long) any());
        doNothing().when(users2).setUserRole((UserRole) any());
        doNothing().when(users2).setUsername((String) any());
        users2.setEmail("jane.doe@example.org");
        users2.setEnabled(true);
        users2.setLocked(true);
        users2.setName("Name");
        users2.setPassword("iloveyou");
        users2.setStudySets(new ArrayList<>());
        users2.setUserID(1L);
        users2.setUserRole(UserRole.USER);
        users2.setUsername("janedoe");

        Users users3 = new Users();
        users3.setEmail("jane.doe@example.org");
        users3.setEnabled(true);
        users3.setLocked(true);
        users3.setName("Name");
        users3.setPassword("iloveyou");
        users3.setStudySets(new ArrayList<>());
        users3.setUserID(1L);
        users3.setUserRole(UserRole.USER);
        users3.setUsername("janedoe");
        assertThrows(IllegalStateException.class, () -> usersService.createUser(users3));
        verify(usersRepository).findByEmail((String) any());
        verify(usersRepository).findByUsername((String) any());
        verify(users2).setEmail((String) any());
        verify(users2).setEnabled((Boolean) any());
        verify(users2).setLocked((Boolean) any());
        verify(users2).setName((String) any());
        verify(users2).setPassword((String) any());
        verify(users2).setStudySets((List<StudySet>) any());
        verify(users2).setUserID((Long) any());
        verify(users2).setUserRole((UserRole) any());
        verify(users2).setUsername((String) any());
    }

    /**
     * Method under test: {@link UsersService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setEnabled(true);
        users.setLocked(true);
        users.setName("Name");
        users.setPassword("iloveyou");
        users.setStudySets(new ArrayList<>());
        users.setUserID(1L);
        users.setUserRole(UserRole.USER);
        users.setUsername("janedoe");
        Optional<Users> ofResult = Optional.of(users);
        when(usersRepository.findByUsername((String) any())).thenReturn(ofResult);
        assertSame(users, usersService.loadUserByUsername("janedoe"));
        verify(usersRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UsersService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        when(usersRepository.findByUsername((String) any())).thenReturn(Optional.empty());
        assertThrows(UsernameNotFoundException.class, () -> usersService.loadUserByUsername("janedoe"));
        verify(usersRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UsersService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername3() throws UsernameNotFoundException {
        when(usersRepository.findByUsername((String) any())).thenThrow(new IllegalStateException());
        assertThrows(IllegalStateException.class, () -> usersService.loadUserByUsername("janedoe"));
        verify(usersRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UsersService#enableUser(String)}
     */
    @Test
    void testEnableUser() {
        when(usersRepository.enableUser((String) any())).thenReturn(1);
        assertEquals(1, usersService.enableUser("jane.doe@example.org"));
        verify(usersRepository).enableUser((String) any());
    }

    /**
     * Method under test: {@link UsersService#enableUser(String)}
     */
    @Test
    void testEnableUser2() {
        when(usersRepository.enableUser((String) any())).thenThrow(new IllegalStateException());
        assertThrows(IllegalStateException.class, () -> usersService.enableUser("jane.doe@example.org"));
        verify(usersRepository).enableUser((String) any());
    }
}

