package com.example.CS3141R01Team2.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author wmisip
 * @author eljones
 * @author mykelly
 *
 * Repository for the Users Entity contains all Queries currently needed for requests
 */
@Repository
public interface UsersRepository
    extends JpaRepository<Users, Long>{

    /**
     * Query to get the user with a specific username
     *
     * @param username the username to search for
     * @return A Users object if a user is found
     */
    @Query("SELECT u FROM users u WHERE u.username = ?1")
    Optional<Users> findByUsername(String username);

    /**
     * Query to get the user with a specific email
     *
     * @param email email to search for
     * @return the Users object if a user is found
     */
    @Query("SELECT u FROM users u WHERE u.email = ?1")
    Optional<Users> findByEmail(String email);

    /**
     * Query to return a List of all Users with specific information
     *
     * @return A List of all Users with their given information
     */
    @Query("SELECT u.userID, u.username, u.password, u.email, u.name FROM users u")
    List<ArrayList<?>> findAllUsers();
}
