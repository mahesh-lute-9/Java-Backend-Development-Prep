package org.example;

import java.util.List;

public class UserService {
//
//    private List<String> userNames;
//
//    public UserService(List<String> userNames){
//        this.userNames = userNames;
//    }
//
//    public List<String> getUserNames(){
//        return userNames;
//    }

    public UserService(){
        System.out.println("UserService created");
    }

    //creating a method so that would call exactly after bean created
    public void init(){
        System.out.println("PostConstruct Phase");
    }

    //creating a method so that it would call exactly before bean getting destroyed
    public void cleanUp(){
        System.out.println("PreDestroy Phase");
    }
}
