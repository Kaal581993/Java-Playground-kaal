package spring.second.tut;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.second.tut.com.example.demo.GreetingService;
import spring.second.tut.com.example.demo.loosecoupling.UserService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

           GreetingService greetingService= (GreetingService) context.getBean("myBean");
           greetingService.sayHello();
//
//           UserService userService =(UserService) context.getBean("EmailNotification");
//           userService.notifyUser("Hello Kaal!");
        UserService userService2 =(UserService) context.getBean("SMSNotification");
        userService2.notifyUser("The Matrix has you!");


    }
}