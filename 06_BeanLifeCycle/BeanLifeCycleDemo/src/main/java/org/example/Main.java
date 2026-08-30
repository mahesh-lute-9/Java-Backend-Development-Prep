package org.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

//        OrderService order = context.getBean(OrderService.class);
//        order.placeOrder();

//        AppConfig config = context.getBean(AppConfig.class);
//        config.demo();

//        UserService userService = context.getBean(UserService.class);
//        userService.setBeanName("userBean2");

//        CartService cart = context.getBean(CartService.class);
//        System.out.println(cart.getValue(1));

//        context.close();
//        Closing the context triggers destruction callbacks for
//        Spring-managed singleton beans.

        /*
         * Calling setBeanName() manually does NOT change the bean name.
         *
         * The method is a Spring callback method.
         * Calling it yourself only executes the method and prints
         * the value passed to it; Spring's bean metadata remains unchanged.
         */
    }
}

/*
 * Spring Bean Lifecycle — Singleton
 *
 * 1. IoC container starts.
 *
 * 2. Configuration is read.
 *    Spring also manages configuration classes as beans.
 *
 * 3. Bean Definitions are created.
 *    Bean Definition contains metadata about each bean.
 *
 * 4. Beans are instantiated and dependencies are injected.
 *
 *    Constructor Injection:
 *    - Object creation and dependency injection happen together.
 *
 *    Setter / Field Injection:
 *    - Object is created first.
 *    - Dependencies are injected afterward.
 *
 * 5. Aware Interfaces are called.
 *    Spring provides container-related information to the bean.
 *
 * 6. Initialization callbacks are called.
 *
 * 7. Bean is ready to use.
 *
 * 8. Destruction callbacks are called when the container is closed.
 *
 * 9. Bean is destroyed.
 */


/*
 * Spring Bean Lifecycle — Prototype
 *
 * 1. IoC container starts.
 *
 * 2. Configuration is read.
 *
 * 3. Bean Definitions are created.
 *
 * 4. Prototype bean is instantiated when requested.
 *
 * 5. Dependencies are injected.
 *
 * 6. Aware Interfaces are called.
 *
 * 7. Initialization callbacks are called.
 *
 * 8. Bean is handed over to the client.
 *
 * Note:
 * Spring does not manage the complete destruction lifecycle
 * of prototype beans after handing them to the client.
 */


/*
 * What are Aware Interfaces?
 *
 * Aware Interfaces are callback interfaces through which Spring
 * provides container-related information or infrastructure to a bean.
 *
 * Examples:
 *
 * BeanNameAware
 *     -> Provides the bean's name.
 *
 * ApplicationContextAware
 *     -> Provides access to the ApplicationContext.
 */