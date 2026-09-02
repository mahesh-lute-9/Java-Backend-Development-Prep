package org.example;

//2 ways to handle beans - 1. Annotation Based, 2.XML configuration based


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order = context.getBean(OrderService.class);
        order.placeOrder();

//        CartService cs = new CartService();
//        cs.addToCart();

//        User user = context.getBean(User.class);
//        System.out.println(user.getName());


        //we can't write @Component to CartService class because this class belong to external JAR dependency we're just trying to get the functionality
//        CartService cs = new CartService();
//        cs.addToCart();

//        PaymentService payment = context.getBean(PaymentService.class);
//        payment.pay();

//        PaymentService service = new PaymentService();
//
//        OrderService order = new OrderService(service);
//        order.placeOrder();

/*
        Student s1 = new Student();

        Class<Student> c1 = Student.class;

//Reflection API provides us metadata about the class, it uses Class<class> class
//Inside it, it saves metadata info like:

class name - Student
fields, datatype - name, age
Constructors -> Student()
Method -> getAttendance(), print()
Annotations
*/

    }
}

/*
class Student{
    private String name;
    private int age;

    public Student(){

    }

    public void getAttendance(){

    }

    public void print(){

    }
}
*/