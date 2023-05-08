package com.example.minescrapeback.entity;

public class UserPassNotMatchException extends Exception {
    public UserPassNotMatchException() {
        super("Password did not match");
    }
}
