package com.example.CS3141R01Team2.Security;

import com.example.CS3141R01Team2.Users.Users;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping
@AllArgsConstructor
public class LoginController{

    private final AuthenticationManager authenticationManager;

//    @PostMapping("/loginuser")
//    public void loginUser(HttpServletRequest request, HttpServletResponse response)
//        throws IOException, ServletException, IllegalStateException {
//        loginService.authenticateUser(request, response);
//    }

    @PostMapping("/login")
    public ResponseEntity<HttpStatus> loginUser(@RequestBody LoginRequest user) throws Exception{
        Authentication auth;
        try{
            auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(auth);

        }catch (BadCredentialsException e){
            throw new Exception("Invalid Credentials");
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
}
