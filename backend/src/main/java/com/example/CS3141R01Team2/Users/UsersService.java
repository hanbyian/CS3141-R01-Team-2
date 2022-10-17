package com.example.CS3141R01Team2.Users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

    public void registerUsers(Users user){
//        Optional<Users> userByEmail = usersRepository;

    }

    public Boolean validatePassword(String inputPassword, String username){
        Optional<Users> userByName = usersRepository.findUserByUsername(username);
        if(userByName.isPresent()){
            String requestedPassword = userByName.get().getPassword();
            if(inputPassword.equals(requestedPassword)){

            }
        }
        return false;
    }
}
