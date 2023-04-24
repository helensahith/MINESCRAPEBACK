package com.example.minescrapeback.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.minescrapeback.entity.UserPer;
import com.example.minescrapeback.repository.CredService;

@RestController
public class DemoController {

    @Autowired
    private CredService crudUser;

    @GetMapping("/world")
    public String world() {
        return "Hello Mowa";
    }

    @PostMapping("/setUser")
    public void setUser() {
        System.out.println("Data Creation Started");
        crudUser.save(new UserPer("Sadhe", "verna"));
        System.out.println("Data Creation Completed");
    }

    @GetMapping("/getUser/{UserName}")
    public List<UserPer> getUser(@PathVariable String UserName) {
        System.out.println("Search started");
        return crudUser.findCredByUser(UserName);
    }

    @GetMapping("/getUserPass/{UserName}")
    public String getUserPass(@PathVariable String UserName) {
        System.out.println("Search started");
        return crudUser.findPassByUser(UserName);
    }
}
