package com.example.CS3141R01Team2;
import com.example.CS3141R01Team2.Users.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class Cs3141R01Team2ApplicationTests {
	@Autowired
	UsersRepository repository;

	UsersService service = new UsersService(repository);

	@Test
	// Test the connection to the entire database
	void contextLoads() {
	}

	@Test
    void testUserAttributes() {
        // Create a users
        Users Bob = new Users("bsmith", "Password", "Bob@gmail.com","Bob");

        // Get all user attributes
        String username = Bob.getUsername();
        String password = Bob.getPassword();
        String email = Bob.getEmail();
        String name = Bob.getName();

        assertEquals("Expecting: bsmith","bsmith",username);
        assertEquals("Expecting: Password","Password",password);
        assertEquals("Expecting: Bob@gmail.com","Bob@gmail.com",email);
        assertEquals("Expecting: Bob","Bob",name);
    }

    @Test
    void testUsersAdded() {
		// Create a users
		Users Bob = new Users("bsmith", "Password", "Bob@gmail.com","Bob");

		// Add user
		service.createUser(Bob);

		List<Users> usersList = service.showUsers();

		assert(usersList.contains(Bob));
    }
}
