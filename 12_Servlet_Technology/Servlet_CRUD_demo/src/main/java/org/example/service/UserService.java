package org.example.service;

import org.example.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private final Map<Integer, User> userDB;

    public UserService(){
        userDB = new HashMap<>();
    }

    // createUser()
    public User createUser(User userReq){
        userDB.put(userReq.getId(),userReq);
        return userReq;
    }

    // getAllUsers()
    public List<User> getAllUsers(){
        List<User> usersResp = new ArrayList<>();

        for(User user : userDB.values()){
            usersResp.add(user);
        }

        return usersResp;
    }

    // getUserById()
    public User getUserById(Integer id){
        return  userDB.getOrDefault(id,null);
    }


}


//every servlet web app creates new endpoint as their name package name

// Tomcat --> servlets
/*
LIFECYCLE:
    init() --> PostConstruct
    service() --> deGet(),..
    destroy() --> PreDestroy()
 */