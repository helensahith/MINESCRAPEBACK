package com.example.minescrapeback.entity;

public class UserNotFoundException extends Exception {
   public UserNotFoundException()
    {
    super("User Does Not Exist");
    }
}
