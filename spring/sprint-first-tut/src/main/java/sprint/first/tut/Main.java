package sprint.first.tut;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sprint.first.tut.com.example.demo.GreetingService;
import sprint.first.tut.com.example.demo.loosecoupling.UserService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationBeanContext.xml");
           GreetingService greetingService= (GreetingService) context.getBean("myBean");
           greetingService.sayHello();

           UserService userService =(UserService) context.getBean("EmailNotification");
           userService.notifyUser("Hello Kaal!");
        UserService userService2 =(UserService) context.getBean("SMSNotification");
        userService2.notifyUser("The Matrix has you!");
    }
}