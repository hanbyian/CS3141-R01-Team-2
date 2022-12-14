package com.example.CS3141R01Team2.Users;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
public class UsersConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(UsersRepository repository){
        return args -> {
            Users wil = new Users(
                "wmisip",
            "123Aei",
            "wmisip@gmail.com",
            "Wil"
            );

            Users ian = new Users(
                "ijhanby",
            "1762fro",
            "ijhanby@gmail.com",
            "Ian"
            );
            
            repository.saveAll(         //saves users
                List.of(wil, ian)
            );
        };
    }


}
