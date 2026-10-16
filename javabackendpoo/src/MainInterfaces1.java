package javabackendpoo.src;

/*
    interface
    -> contrato
    -> "qué puede hacer"

    abstract class
    -> base común
    -> "qué comparte" 
*/

class EmailNotificationService implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("Enviando email: " + message);
    }

}

class SmsNotificationService implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("Enviando SMS: " + message);
    }

}

class UserService {
    private NotificationService notificationService;

    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void registerUser() {
        System.out.println("Usuario registrado");
        notificationService.send("Bienvenido");
    }
}

public class MainInterfaces1 {
    public static void main(String[] args) {
        NotificationService servicio1 = new EmailNotificationService();
        NotificationService servicio2 = new SmsNotificationService();

        servicio1.send("Hola");
        servicio2.send("Hola");

        UserService user1 = new UserService(servicio1);
        UserService user2 = new UserService(servicio2);
        user1.registerUser();
        user2.registerUser();
    }
}
