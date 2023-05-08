package com.example.minescrapeback.entity;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException() {
        super("An Account with this username already exists");
    }
}
