package com.example.CS3141R01Team2.Users;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.CS3141R01Team2.Registration.token.ConfirmationToken;
import com.example.CS3141R01Team2.Registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author wmisip
 * @author eljones
 * @author mykelly
 *
 * Service method for the Users Controller allowing the api to make calls to the repository
 */
@Service
@AllArgsConstructor
public class UsersService implements UserDetailsService {

    private final String USER_NOT_FOUND_MSG =
            "user with email %s not found";
    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ConfirmationTokenService confirmationTokenService;


//    @Autowired
//    public UsersService(UsersRepository usersRepository) {
//        this.usersRepository = usersRepository;
//    }

    /**
     * method to return a List of all users in the database and their registration information
     *
     * @return List of ArrayList of each users information each ArrayList containing
     * a users ID, username, password, email, and name
     */
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
    public String createUser(Users user) {
        Optional<Users> getUserByUsername = usersRepository.findByUsername(user.getUsername());

        if(getUserByUsername.isPresent() && getUserByUsername.get().getEnabled() == true){
            throw new IllegalStateException("username already exists!");
        } else{
            Optional<Users> getUserByEmail = usersRepository.findByEmail(user.getEmail());
            if(getUserByEmail.isPresent()){
                if(getUserByEmail.get().getUsername().equals(user.getUsername()) &&
                        getUserByEmail.get().getEmail().equals(user.getEmail())
                && !getUserByEmail.get().getEnabled()){
                    String token = UUID.randomUUID().toString();
                    ConfirmationToken confirmationToken = new ConfirmationToken(

                            token,
                            LocalDateTime.now(),
                            LocalDateTime.now().plusMinutes(15),
                            getUserByEmail.get()

                    );

                    confirmationTokenService.saveConfirmationToken(
                            confirmationToken
                    );

                    return token;
                }else{
                    throw new IllegalStateException("email already taken!");
                }
            } else{
                String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

                user.setPassword(encodedPassword);

                usersRepository.save(user);

                String token = UUID.randomUUID().toString();
                ConfirmationToken confirmationToken = new ConfirmationToken(

                        token,
                        LocalDateTime.now(),
                        LocalDateTime.now().plusMinutes(15),
                        user

                );

                confirmationTokenService.saveConfirmationToken(
                        confirmationToken
                );

                return token;
            }
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return usersRepository.findByUsername(username).orElseThrow(()->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, username)));
    }

    public int enableUser(String email) {
        return usersRepository.enableUser(email);
    }


//    /**
//     * Takes a username and password. First checks if the username exists, then checks
//     * if the existing username's password matches the password given at sign in.
//     *
//     * @param   username
//     * @param   inputPassword
//     * @return  true if inPass matches the password created at user creation
//     *          false if inPass is not password created at user creation
//     */
//    public boolean testPassword(String username, String inputPassword){
//        Optional<Users> getUserByUsername = usersRepository.findByUsername(username);
//
//        if(getUserByUsername.isPresent()){
//            throw new IllegalStateException("user does not exist");
//        } else{
//            if(inputPassword == getUserByUsername.get().getPassword()){
//                return true;
//            } else {
//                return false;
//            }
//        }
//    }

}
