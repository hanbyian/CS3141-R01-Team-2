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
     *
     * @param user
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

    public boolean testPassword(String username, String inputpassword){
        Optional<Users> getUserByUsername = usersRepository.findByUsername(username);

        if(!getUserByUsername.isPresent()){
            throw new IllegalStateException("user does not exist");
        } else{
            if(inputpassword == getUserByUsername.get().getPassword()){
                return true;
            } else {
                return false;
            }
        }
    }



//    public boolean confirmUser(String username, String password) {
//        return ( usersRepository.findById(username) && usersRepository.findById(password) );
//    }
// commented out until further discussion with group
}
