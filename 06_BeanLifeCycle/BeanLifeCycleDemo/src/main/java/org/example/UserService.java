package org.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component("userBean")     //by default singleton -- eager initialization scope
//changing the bean name as from userService to "userBean"
public class UserService implements BeanNameAware, ApplicationContextAware {

    public UserService(){
        System.out.println("Constructor called");
    }

    @Override
    public void setBeanName(String name) {  // Aware interface method
        System.out.println("Bean name is " + name); //bean name is class name is camelCase notation by default
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext name is " + applicationContext.getClass());
    }
    // WHY does they are written like setter method cause it is a Spring callback method & we are getting something though, so

//    public String getBean(){
//        return "userBean";  //we created a normal method to just print
//    }

}
