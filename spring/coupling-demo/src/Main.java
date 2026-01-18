import loosecoupling.EmailNotificationService;
import loosecoupling.NotificationService;
import loosecoupling.SMSNotificationService;
import tightcoupling.UserService;

public class Main{
    public static void main(String[] args) {

        //Tight Coupling example
        UserService userService = new UserService();
        userService.notifyUser("\nHello KAAL!\n");

        // Loose Coupling example
        NotificationService emailService = new EmailNotificationService();
        loosecoupling.UserService userServiceloose = new loosecoupling.UserService(emailService);
        userServiceloose.notifyUser("Hello Kaal! The Matrix has you!");

        NotificationService smsServiceLoose = new SMSNotificationService();
        loosecoupling.UserService userServiceSMS = new loosecoupling.UserService(smsServiceLoose);
        userServiceSMS.notifyUser("Follow the white Rabbit!");

        /**
         *
         * Types of DI:
         *
         * Constructor Injection
         * Setter Injection
         * Feild Injection
         * */

        // Setter Injection example:

        loosecoupling.UserService userServiceLooseSetter =
                new loosecoupling.UserService(smsServiceLoose);

        userServiceLooseSetter.setNotificationService(emailService);

        //Field Injection
        userServiceLooseSetter.notificationService = smsServiceLoose;



    }
}