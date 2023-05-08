package com.example.minescrapeback.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.minescrapeback.entity.UserPer;

public interface CredService extends MongoRepository<UserPer, String> {

    @Query("{UserName:'?0'}")
    List<UserPer> findCredByUser(String UserName);

    @Query(value = "{UserName:'?0'}", fields = "{'_id':0,'Password':1}")
    UserPer findPassByUser(String UserName);

    public long count();
}
