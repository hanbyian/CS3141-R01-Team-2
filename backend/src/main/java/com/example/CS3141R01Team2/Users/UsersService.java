package com.example.CS3141R01Team2.Users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    
    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> showUsers(){
       return usersRepository.findAll(); //returns list of all users
    }

    /**
     * createUser
     * @param username
     * @param password
     * @param email
     * @param name
     */
    public void createUser(String username, String password, String email, String name) {
        usersRepository.save(new Users(username, password, email, name));
    }

//    public boolean confirmUser(String username, String password) {
//        return ( usersRepository.findById(username) && usersRepository.findById(password) );
//    }
// commented out until further discussion with group
}
