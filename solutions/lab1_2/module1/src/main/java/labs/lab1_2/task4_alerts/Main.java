package labs.lab1_2.task4_alerts;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 1.2, task 4. Do not change this class.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardConfig.class)) {
            FraudAlerts alerts = context.getBean(FraudAlerts.class);
            alerts.alert("Card 4242: payment of 6000 EUR blocked");
            System.out.println("Channels: " + alerts.channels());
        }
    }
}
