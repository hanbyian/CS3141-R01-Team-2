package com.example.CS3141R01Team2.Users;

import java.util.ArrayList;
import java.util.List;

import com.example.CS3141R01Team2.Security.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

/**
 * @author wmisip
 * @author eljones
 * @author mykelly
 *
 * UsersController class maps the endpoints for API calls. It holds various Get, Post, Update,
 * and Delete mappings for the API
 */
//Controllers expose the endpoints to whatever needs to call them.
@RestController //RestController means http request will be handled by this controller
@RequestMapping(path="users") //Tells where to search for the endpoint in when we request something
public class UsersController {

    private final UsersService userService;

    @Autowired //userService will automatically be instantiated and injected into the constructor
    public UsersController(UsersService userService) {
        this.userService = userService;
    }

    /**
     * Get Request to get all users in the system and their registration information
     *
     * @return List of ArrayLists containing each Users registration information
     */
    @GetMapping ("/showusers")//States that the following method is a Get Request
    public List<ArrayList<?>> showUsers(){
      return userService.showUsers();
    }

    /**
     * Post Request to create a new user
     *
     * @param user Takes in a JSON request containing the users data
     */
    @PostMapping("/createUser")
    public void createUser(@RequestBody Users user) {  //convert password to hash?
        userService.createUser(user);
    }

    @GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model){
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);
        return "registration";
    }

/*    @GetMapping("/authenticate/{username}/{password}")
    public Boolean getPassword(@PathVariable String username, @PathVariable String inputpassword){
        return userService.testPassword(username, inputpassword);
    }

 */
}
