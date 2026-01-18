package spring.second.tut.com.example.demo.loosecoupling;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("SMSNotification")
public class UserService {
   public NotificationService notificationService;
    public UserService() {
    }

    @Autowired
    public UserService(NotificationService notificationService) {
        this.notificationService=notificationService;
    }

    public void notifyUser(String message){
        notificationService.send("\nHello KAAL! The Matrix has you!\n"+message);
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
}
