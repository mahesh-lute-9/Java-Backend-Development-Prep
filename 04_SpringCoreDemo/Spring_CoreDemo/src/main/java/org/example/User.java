package org.example;

import org.springframework.stereotype.Component;

//@Component  //we cannot use component in this case as it expects the values of fields at the time of creation, it can't just give null values
//also we can't add the component if we are using external files code like from other JAR
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
