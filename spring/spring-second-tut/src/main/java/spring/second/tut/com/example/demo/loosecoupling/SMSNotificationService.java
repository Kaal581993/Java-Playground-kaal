package spring.second.tut.com.example.demo.loosecoupling;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SMSNotificationService implements NotificationService{
    @Override
    public void send(String message) {
        System.out.println("SMS:"+message);
    }

}
