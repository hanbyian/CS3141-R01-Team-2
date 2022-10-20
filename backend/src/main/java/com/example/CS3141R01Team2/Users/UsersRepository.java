package com.example.CS3141R01Team2.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository
    extends JpaRepository<Users, Long>{

    @Query("SELECT u FROM users u WHERE u.username = ?1")
    Optional<Users> findByUsername(String username);

    @Query("SELECT u FROM users u WHERE u.email = ?1")
    Optional<Users> findByEmail(String email);

    @Query("SELECT u.userID, u.username, u.password, u.email, u.name FROM users u")
    List<ArrayList<?>> findAllUsers();
}
