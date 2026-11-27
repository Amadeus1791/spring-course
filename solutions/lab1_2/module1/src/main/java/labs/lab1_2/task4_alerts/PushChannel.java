package labs.lab1_2.task4_alerts;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class PushChannel implements AlertChannel {

    @Override
    public void send(String message) {
        System.out.println("[push]  " + message);
    }
}
