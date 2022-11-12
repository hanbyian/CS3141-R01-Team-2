package com.example.CS3141R01Team2.Users;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author wmisip
 * @author eljones
 * @author mykelly
 *
 * @deprecated
 *
 * Initial Configuration file for the Users table used for some testing features during initial
 * Development
 */
@Configuration
@AllArgsConstructor
public class UsersConfig {

    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Bean
    CommandLineRunner commandLineRunner(UsersRepository repository){
        return args -> {
            Users wil = new Users(
                "wmisip",
            bCryptPasswordEncoder.encode("wmisip"),
            "wmisip@gmail.com",
            "Wil",
                    UserRole.ADMIN,
                    true
            );

            Users ian = new Users(
                "ijhanby",
            bCryptPasswordEncoder.encode("ijhanby"),
            "ijhanby@gmail.com",
            "Ian",
                    UserRole.USER,
                    true
            );
            
            repository.saveAll(         //saves users
                List.of(wil, ian)
            );
        };
    }


}
