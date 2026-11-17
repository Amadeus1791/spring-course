package labs.lab1_2.task4_alerts;

import org.springframework.stereotype.Component;

@Component
public class PushChannel implements AlertChannel {

    @Override
    public void send(String message) {
        System.out.println("[push]  " + message);
    }
}
