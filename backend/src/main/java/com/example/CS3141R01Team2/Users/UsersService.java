package com.example.CS3141R01Team2.Users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    
    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public List<Users> showUsers(){
       return usersRepository.findAll(); //returns list of all users
    }

//    @PostMapping
//    public Boolean validatePassword(String inputPassword, String username){
//        Optional<Users> userByName = usersRepository.findUserByUsername(username);
//        if(userByName.isPresent()){
//            String requestedPassword = userByName.get().getPassword();
//            if(inputPassword.equals(requestedPassword)){
//
//            }
//        }
//        return false;
//    }
    /**
     * createUser
     * @param username
     * @param password
     * @param email
     * @param name
     */

    @PostMapping
    public void createUser(String username, String password, String email, String name) {
        Optional<Users> findUserByName = usersRepository.findUserByUsername(username);

        if(findUserByName.isPresent()){
            throw new IllegalArgumentException("username already exist!");
        }
        else{
            Optional<Users> findUserByEmail = usersRepository.findUserByEmail(email);
            if(findUserByEmail.isPresent()){
                throw new IllegalArgumentException("email already exist!");
            } else{
                usersRepository.save(new Users(username, password, email, name));
            }
        }
    }

//    public boolean confirmUser(String username, String password) {
//        return ( usersRepository.findById(username) && usersRepository.findById(password) );
//    }
// commented out until further discussion with group
}
