package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.HashMap;
import java.util.Map;

public class CartService implements BeanNameAware, ApplicationContextAware
        /* InitializingBean, DisposableBean */ {

    private Map<Integer, String> mp;

    public CartService() {
        mp = new HashMap<>();
        System.out.println("CartService constructor called");
    }

    /*
     * Initialization callback options:
     *
     * 1. InitializingBean -> afterPropertiesSet()
     * 2. initMethod       -> custom initialization method
     * 3. @PostConstruct   -> recommended/common approach
     *
     * @PostConstruct runs after Spring has completed dependency injection
     * and other bean configuration.
     */

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("Bean is ready");
//        mp.put(1, "Mahesh");
//        mp.put(2, "Rohit");
//    }

//    public void start() {
//        System.out.println("Bean is ready");
//        mp.put(1, "Mahesh");
//        mp.put(2, "Rohit");
//    }

    @Override
    public void setBeanName(String name) {

        // Spring calls this callback and provides the bean name.
        System.out.println("Bean name is " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {

        // Spring calls this callback and provides the ApplicationContext.
        System.out.println(
                "ApplicationContext name is " + applicationContext.getClass()
        );
    }

    @PostConstruct
    public void start2() {
        System.out.println("Bean is ready");

        mp.put(1, "Mahesh");
        mp.put(2, "Rohit");
    }

    @PreDestroy
    public void stop() {
        mp.clear();
        System.out.println("Bean is getting destroyed");
    }

    public String getValue(int key) {
        return mp.get(key);
    }

    public void addToCart() {
        System.out.println("Added to cart");
    }

//    @Override
//    public void destroy() throws Exception {
//        mp.clear();
//        System.out.println("Bean is getting destroyed");
//    }
}

/*
 * Initialization callbacks:
 *
 * 1. InitializingBean -> afterPropertiesSet()
 * 2. initMethod
 * 3. @PostConstruct
 *
 * Why not use the constructor instead of @PostConstruct?
 *
 * Constructor:
 * - Used for required dependencies.
 * - Used to establish the basic valid state of the object.
 *
 * @PostConstruct:
 * - Runs after Spring completes dependency injection and configuration.
 * - Useful when initialization depends on Spring-injected values or
 *   other bean configuration being ready.
 *
 *
 * Destruction callbacks:
 *
 * 1. DisposableBean -> destroy()
 * 2. destroyMethod
 * 3. @PreDestroy
 *
 * Note:
 * Prototype beans do not receive Spring's destruction callbacks
 * automatically because Spring does not manage their complete lifecycle
 * after handing them to the client.
 */