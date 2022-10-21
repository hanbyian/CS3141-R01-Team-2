package com.example.CS3141R01Team2.Users;

import java.util.ArrayList;
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
    public List<ArrayList<?>> showUsers(){
       return usersRepository.findAllUsers(); //returns list of all users
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
     * Take in a user entity and checks if the username and email are both unique.
     * Once checked, a user account is saved in usersRepository which allows a user to create
     * and view study sets and terms.
     *
     * @param user  user entity, user + password that wants to be created
     */
    public void createUser(Users user) {
        Optional<Users> getUserByUsername = usersRepository.findByUsername(user.getUsername());

        if(getUserByUsername.isPresent()){
            throw new IllegalStateException("username already exists!");
        } else{
            Optional<Users> getUserByEmail = usersRepository.findByEmail(user.getEmail());
            if(getUserByEmail.isPresent()){
                throw new IllegalStateException("email already taken!");
            } else{
                usersRepository.save(user);
            }
        }

    }

    /**
     * Takes a username and password. First checks if the username exists, then checks
     * if the existing username's password matches the password given at sign in.
     *
     * @param   username
     * @param   inputPassword
     * @return  true if inPass matches the password created at user creation
     *          false if inPass is not password created at user creation
     */
    public boolean testPassword(String username, String inputPassword){
        Optional<Users> getUserByUsername = usersRepository.findByUsername(username);

        if(getUserByUsername.isPresent()){
            throw new IllegalStateException("user does not exist");
        } else{
            if(inputPassword == getUserByUsername.get().getPassword()){
                return true;
            } else {
                return false;
            }
        }
    }

}
