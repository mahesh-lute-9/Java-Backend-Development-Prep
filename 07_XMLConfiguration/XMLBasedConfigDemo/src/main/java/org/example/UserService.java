package org.example;

import java.util.List;

public class UserService {

//    // This is an example of constructor injection.
//    //
//    // Spring can create the List and pass it into the
//    // UserService constructor through XML configuration.
//
//    private List<String> userNames;
//
//
//    public UserService(List<String> userNames){
//        this.userNames = userNames;
//    }
//
//
//    public List<String> getUserNames(){
//        return userNames;
//    }


    // Default constructor.
    //
    // Spring calls this constructor when it creates
    // the UserService bean (assuming no other constructor
    // is configured).
    public UserService() {
        System.out.println("UserService created");
    }


    // Initialization method.
    //
    // This method is intended to run AFTER Spring creates
    // and initializes the bean.
    //
    // IMPORTANT:
    // Spring does NOT automatically know that this is an
    // initialization method just because it is named "init".
    //
    // In XML configuration, we will explicitly tell Spring:
    //
    //     init-method="init"
    //
    // This is similar to the purpose of @PostConstruct,
    // but here we are configuring it through XML.
    public void init() {
        System.out.println("PostConstruct Phase");
    }


    // Destruction method.
    //
    // This method is intended to run BEFORE Spring destroys
    // the bean.
    //
    // Again, Spring does NOT automatically call this method
    // just because it is named "cleanUp".
    //
    // In XML configuration, we will tell Spring:
    //
    //     destroy-method="cleanUp"
    //
    // This is similar to the purpose of @PreDestroy.
    public void cleanUp() {
        System.out.println("PreDestroy Phase");
    }
}