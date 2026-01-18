package sprint.first.tut.com.example.demo.loosecoupling;

public class SMSNotificationService implements NotificationService{
    @Override
    public void send(String message) {
        System.out.println("SMS:"+message);
    }

}
