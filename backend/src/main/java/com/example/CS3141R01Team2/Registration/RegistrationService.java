package com.example.CS3141R01Team2.Registration;

import com.example.CS3141R01Team2.Registration.token.ConfirmationToken;
import com.example.CS3141R01Team2.Registration.token.ConfirmationTokenService;
import com.example.CS3141R01Team2.Users.UserRole;
import com.example.CS3141R01Team2.Users.Users;
import com.example.CS3141R01Team2.Users.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService{

    private final UsersService usersService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;


    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("Email not valid");
        }
        return usersService.createUser(
                new Users(
                        request.getUsername(),
                        request.getPassword(),
                        request.getEmail(),
                        request.getName(),
                        UserRole.USER
                )
        );
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        usersService.enableUser(
                confirmationToken.getUsers().getEmail());
        return "confirmed";
    }
}
