package com.example.CS3141R01Team2.Registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class RegistrationRequest {

    private final String username;
    private final String password;
    private final String email;
    private final String name;

}
