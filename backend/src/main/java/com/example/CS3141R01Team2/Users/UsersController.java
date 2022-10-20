package com.example.CS3141R01Team2.Users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    public List<ArrayList<?>> showUsers(){
      return userService.showUsers();
    }

    @PostMapping("/createUser")
    public void createUser(@RequestBody Users user) {  //convert password to hash?
        userService.createUser(user);
    }

/*    @GetMapping("/authenticate/{username}/{password}")
    public Boolean getPassword(@PathVariable String username, @PathVariable String inputpassword){
        return userService.testPassword(username, inputpassword);
    }
    
 */
}
