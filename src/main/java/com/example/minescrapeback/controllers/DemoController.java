package com.example.minescrapeback.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.minescrapeback.entity.UserAlreadyExistsException;
import com.example.minescrapeback.entity.UserNotFoundException;
import com.example.minescrapeback.entity.UserPassNotMatchException;
import com.example.minescrapeback.entity.UserPer;
import com.example.minescrapeback.repository.CredService;

@RestController
public class DemoController {

    @Autowired
    private CredService crudUser;
    private BCryptPasswordEncoder bcrypt;

    @GetMapping("/world")
    public String world() {
        return "Hello Mowa";
    }

    @PostMapping("/setCred")
    public void setUser(@RequestBody UserPer temp) throws UserAlreadyExistsException {
        bcrypt = new BCryptPasswordEncoder();
        UserPer dbtemp = getUserPass(temp.getUserName());
        if (dbtemp == null) {
            System.out.println("Data Creation Started");
            crudUser.save(new UserPer(temp.getUserName(), bcrypt.encode(temp.getPassword())));
            System.out.println("Data Creation Completed");
        } else {
            throw new UserAlreadyExistsException();
        }
    }

    @GetMapping("/validateCred")
    public Boolean validate(@RequestBody UserPer temp) throws UserNotFoundException, UserPassNotMatchException {
        UserPer dbPass = getUserPass(temp.getUserName());
        if (dbPass == null) {
            throw new UserNotFoundException();
        }
        bcrypt = new BCryptPasswordEncoder();
        System.out.println(temp.getUserName() + " " + temp.getPassword() + " " + dbPass.getPassword());
        if (bcrypt.matches(temp.getPassword(), dbPass.getPassword()))
            return true;
        else {
            throw new UserPassNotMatchException();
        }

    }

    public UserPer getUserPass(String UserName) {
        return crudUser.findPassByUser(UserName);
    }
}
