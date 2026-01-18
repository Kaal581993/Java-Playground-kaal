package sprint.first.tut.com.example.demo.loosecoupling;

public class EmailNotificationService implements NotificationService{

    @Override
    public void send(String message) {
        System.out.println("Email:"+message);
    }


}
