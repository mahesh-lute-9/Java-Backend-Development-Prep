package org.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

// @Component("userBean")
// By default, @Component creates a singleton bean with eager initialization.
// "userService" would be the default bean name.
// "userBean" changes the bean name explicitly.
public class UserService implements BeanNameAware, ApplicationContextAware {

    public UserService() {
        System.out.println("Constructor called");
    }

    @Override
    public void setBeanName(String name) {

        // Spring calls this callback and passes the bean's name.
        System.out.println("Bean name is " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {

        // Spring calls this callback and passes the ApplicationContext.
        System.out.println(
                "ApplicationContext name is " + applicationContext.getClass()
        );
    }

    /*
     * These methods look like setter methods because they follow
     * the "set..." naming convention.
     *
     * But they are not ordinary setter methods.
     * They are callback methods defined by the Aware interfaces.
     *
     * Spring automatically calls them during the bean lifecycle
     * and provides the required information/object.
     */

//    public String getBean() {
//        return "userBean";
//    }

    /*
     * This would be a normal method.
     * Spring would not automatically call it because it is not
     * a lifecycle callback method.
     */
}