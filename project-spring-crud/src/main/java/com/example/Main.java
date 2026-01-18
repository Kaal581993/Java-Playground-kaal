package com.example;

import com.example.config.AppConfig;
import com.example.controller.UserController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        UserController controller = applicationContext.getBean(UserController.class);

        controller.createUser("Alice");

        controller.createUser("Bob");
        controller.createUser("Johnny Sins");
        controller.createUser("Horny Singh");
        controller.createUser("KAAL");


        controller.listUser();

    }

}
