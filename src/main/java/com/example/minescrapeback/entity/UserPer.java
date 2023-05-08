package com.example.minescrapeback.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("usercreds")
public class UserPer {
    private String UserName;
    private String Password;

    public UserPer(String UserName, String Password) {
        this.UserName = UserName;
        this.Password = Password;
    }

    public String getUserName() {
        return this.UserName;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return UserName + " " + Password;
    }
}
