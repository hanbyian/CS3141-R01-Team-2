package com.example.CS3141R01Team2.Users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/users")
public class UsersController {

    private final UsersService userService;

    @Autowired //userService will automatically be instantiated and injected into the constructor
    public UsersController(UsersService userService) {
        this.userService = userService;
    }

    @GetMapping("/showUsers")
    public List<Users> showUsers(){
      return userService.showUsers();  
    }

    @PostMapping("/createUser")
    public void createUser(Users user) {  //convert password to hash?
        userService.createUser(user);
    }

    @GetMapping("/authenticate")
    public Boolean getPassword(String username, String inputpassword){
        return userService.testPassword(username, inputpassword);
    }

    // public boolean confirmUser(String username, String password){
    //     return confirmUser(username, password);
    // }
    // commented out until further discussion with group
}
