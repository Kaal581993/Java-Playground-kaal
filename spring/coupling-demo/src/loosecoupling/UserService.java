package loosecoupling;



public class UserService {
   public NotificationService notificationService;
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
