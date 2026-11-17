package labs.lab1_2.task4_alerts;

import org.springframework.stereotype.Component;

@Component
public class SmsChannel implements AlertChannel {

    @Override
    public void send(String message) {
        System.out.println("[sms]   " + message);
    }
}
