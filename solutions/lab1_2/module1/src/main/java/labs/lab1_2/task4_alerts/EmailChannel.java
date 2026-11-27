package labs.lab1_2.task4_alerts;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class EmailChannel implements AlertChannel {

    @Override
    public void send(String message) {
        System.out.println("[email] " + message);
    }
}
