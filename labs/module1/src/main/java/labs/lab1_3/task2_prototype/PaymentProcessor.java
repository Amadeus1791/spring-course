package labs.lab1_3.task2_prototype;

import java.util.List;
import org.springframework.stereotype.Service;

// Processes card payments. One processor for the whole application.
@Service
public class PaymentProcessor {

    private final Authorization authorization;

    public PaymentProcessor(Authorization authorization) {
        this.authorization = authorization;
    }

    public List<String> process(String card, int amount) {
        authorization.step("check card " + card);
        authorization.step("approve " + amount + " EUR");
        return authorization.steps();
    }
}
