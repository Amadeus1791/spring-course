package labs.lab1_3.task3_wrapper;

import org.springframework.stereotype.Component;

@Component
public class SmsNotifier implements CardNotifier {

    @Override
    public void send(String message) {
        System.out.println("[sms] " + message);
    }
}
