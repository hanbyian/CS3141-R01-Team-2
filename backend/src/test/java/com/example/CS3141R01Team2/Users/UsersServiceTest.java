package com.example.CS3141R01Team2.Users;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UsersService.class})
@ExtendWith(SpringExtension.class)
class UsersServiceTest {
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
        when((List<ArrayList<?>>) usersRepository.findAllUsers()).thenThrow(new IllegalStateException("foo"));
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
        users.setName("Name");
        users.setPassword("iloveyou");
        users.setUsername("janedoe");

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setName("Name");
        users1.setPassword("iloveyou");
        users1.setUsername("janedoe");
        Optional<Users> ofResult = Optional.of(users1);

        Users users2 = new Users();
        users2.setEmail("jane.doe@example.org");
        users2.setName("Name");
        users2.setPassword("iloveyou");
        users2.setUsername("janedoe");
        Optional<Users> ofResult1 = Optional.of(users2);
        when(usersRepository.save((Users) any())).thenReturn(users);
        when(usersRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(usersRepository.findByUsername((String) any())).thenReturn(ofResult1);

        Users users3 = new Users();
        users3.setEmail("jane.doe@example.org");
        users3.setName("Name");
        users3.setPassword("iloveyou");
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
        users.setName("Name");
        users.setPassword("iloveyou");
        users.setUsername("janedoe");

        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setName("Name");
        users1.setPassword("iloveyou");
        users1.setUsername("janedoe");
        Optional<Users> ofResult = Optional.of(users1);
        when(usersRepository.save((Users) any())).thenReturn(users);
        when(usersRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(usersRepository.findByUsername((String) any())).thenReturn(Optional.empty());

        Users users2 = new Users();
        users2.setEmail("jane.doe@example.org");
        users2.setName("Name");
        users2.setPassword("iloveyou");
        users2.setUsername("janedoe");
        assertThrows(IllegalStateException.class, () -> usersService.createUser(users2));
        verify(usersRepository).findByEmail((String) any());
        verify(usersRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UsersService#createUser(Users)}
     */
    @Test
    void testCreateUser3() {
        when(usersRepository.save((Users) any())).thenThrow(new IllegalStateException("foo"));
        when(usersRepository.findByEmail((String) any())).thenThrow(new IllegalStateException("foo"));
        when(usersRepository.findByUsername((String) any())).thenThrow(new IllegalStateException("foo"));

        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setName("Name");
        users.setPassword("iloveyou");
        users.setUsername("janedoe");
        assertThrows(IllegalStateException.class, () -> usersService.createUser(users));
        verify(usersRepository).findByUsername((String) any());
    }
}

