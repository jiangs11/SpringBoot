package com.example.demo.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(long userID) {
        super(String.format("User is not found with id : %s", userID));
    }
}
