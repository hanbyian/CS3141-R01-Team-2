package com.example.CS3141R01Team2.Users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//Controllers expose the endpoints to whatever needs to call them.
@RestController //RestController means http request will be handled by this controller
@RequestMapping(path="api/v1/users") //Tells where to search for the endpoint in when we request something
public class UsersController {

    private final UsersService userService;

    @Autowired //userService will automatically be instantiated and injected into the constructor
    public UsersController(UsersService userService) {
        this.userService = userService;
    }

    @GetMapping ("/showusers")//States that the following method is a Get Request
    public List<Users> showUsers(){
      return userService.showUsers();  
    }

    @PostMapping("/createuser")
    public void createUser(String username, String password, String email, String name) {  //convert password to hash?
        userService.createUser(username, password, email, name);
    }

    // public boolean confirmUser(String username, String password){
    //     return confirmUser(username, password);
    // }
    // commented out until further discussion with group
}
