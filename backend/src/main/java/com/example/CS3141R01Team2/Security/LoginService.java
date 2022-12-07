package com.example.CS3141R01Team2.Security;//package com.example.CS3141R01Team2.Security;
//
//import com.example.CS3141R01Team2.Security.JBCrypt.BCrypt;
//import com.example.CS3141R01Team2.Users.Users;
//import com.example.CS3141R01Team2.Users.UsersRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.Optional;
//
//@Service
//@AllArgsConstructor
//public class LoginService {
//
//    UsersRepository usersRepository;
//
//    public void authenticateUser(
//            HttpServletRequest request,
//            HttpServletResponse response)
//            throws IllegalStateException, ServletException, IOException {
//        Optional<Users> users =  usersRepository.findByUsername(request.getParameter("username"));
//        if(users.isPresent()){
//            Users user = users.get();
//            if(user.getEnabled()){
//                if(BCrypt.checkpw(request.getParameter("password"), user.getPassword())){
//                    HttpSession oldSession = request.getSession(false);
//                    if (oldSession != null) {
//                        oldSession.invalidate();
//                    }
//                    HttpSession newSession = request.getSession(true);
//
//                    //setting session to expiry in 5 mins
//                    newSession.setMaxInactiveInterval(5*60);
//
//                    Cookie message = new Cookie("message", "Welcome");
//                    response.addCookie(message);
//                    response.sendRedirect("https://google.com");
//                }else{
//                    throw new IllegalStateException("Wrong username and password combination");
//                }
//            }else{
//                throw new IllegalStateException("User not verified, please check your email");
//            }
//
//        }else{
//            throw new IllegalStateException(
//                    "Unable to find user with username provided!!");
//        }
//    }
//}
