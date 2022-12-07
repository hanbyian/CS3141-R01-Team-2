package com.example.CS3141R01Team2.Security;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class LoginRequest {

    private final String username;
    private final String password;

}
