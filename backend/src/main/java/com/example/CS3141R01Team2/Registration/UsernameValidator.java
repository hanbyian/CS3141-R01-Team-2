package com.example.CS3141R01Team2.Registration;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class UsernameValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        String regex = "^[A-Za-z0-9+_.-]";

        Pattern pattern = Pattern.compile(regex);

        if(pattern.matcher(s).matches()){
            return true;
        }
        return false;
    }
}
