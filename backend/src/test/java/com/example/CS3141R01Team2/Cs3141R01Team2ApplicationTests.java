package com.example.CS3141R01Team2;
import com.example.CS3141R01Team2.Users.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class Cs3141R01Team2ApplicationTests {
	@Autowired
    public UsersRepository repository;

	UsersService service = new UsersService(repository);

	@Test
	// Test the connection to the entire database
	public void contextLoads() {
	}

    /* Test UsersService Class methods*/
    @Test
    public void testCreateUserObj() {
        // Create a users
        Users Bob = new Users();

        // Set all attributes
        Bob.setUsername("bsmith");
        Bob.setPassword("Password");
        Bob.setEmail("Bob@gmail.com");
        Bob.setName("Bob");

        // Get all user attributes
        String username = Bob.getUsername();
        String password = Bob.getPassword();
        String email = Bob.getEmail();
        String name = Bob.getName();

        assertEquals("bsmith",username);
        assertEquals("Password",password);
        assertEquals("Bob@gmail.com",email);
        assertEquals("Bob",name);
    }

    @Test
    public void testcreateUser() {
		// Create a users
		Users Bob = new Users("bsmith", "Password", "Bob@gmail.com","Bob");

		// Add user
		service.createUser(Bob);

		List<Users> usersList = service.showUsers();

        // Confirm Bob was added to the user list
		assert(usersList.contains(Bob));
    }

    @Test
    public void testShowUsers() {
        // Create users
        Users Bob = new Users("bsmith", "Password", "Bob@gmail.com","Bob");
        Users Alice = new Users("asmith", "P@ssw0rd", "Alice@gmail.com","Alice");
        Users Eve = new Users("esmith", "passw0rd", "Eve@gmail.com","Eve");


        // Add user
        service.createUser(Bob);
        service.createUser(Alice);
        service.createUser(Eve);

        List<Users> usersList = service.showUsers();

        boolean correctList = usersList.contains(Bob) && usersList.contains(Alice) && usersList.contains(Eve);

        // Confirm Bob was added to the userList
        assert(correctList);
    }

    @Test
    public void testTestPassword() {
        // Create a user
        Users Bob = new Users("bsmith", "Password", "Bob@gmail.com","Bob");

        // Test user's password
        boolean result = service.testPassword(Bob.getUsername(),Bob.getPassword());

        // Confirm it is true
        assert(result);
    }
}
