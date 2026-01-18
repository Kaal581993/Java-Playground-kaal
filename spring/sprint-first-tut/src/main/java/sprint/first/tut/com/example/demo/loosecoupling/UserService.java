package sprint.first.tut.com.example.demo.loosecoupling;



public class UserService {
   public NotificationService notificationService;
    public UserService() {
    }
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
