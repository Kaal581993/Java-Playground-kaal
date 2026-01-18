package tightcoupling;

public class UserService {

    public void notifyUser(String message){
        NotificationService notifiationService = new NotificationService();

        notifiationService.send("\nHello KAAL! The Matrix has you!\n");
    }
}
