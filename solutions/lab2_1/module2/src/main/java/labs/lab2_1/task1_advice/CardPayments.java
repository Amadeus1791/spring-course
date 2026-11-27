package labs.lab2_1.task1_advice;

import org.springframework.stereotype.Component;

// Takes card payments. A negative amount is refused.
@Component
public class CardPayments {

    public String pay(int amount) {
        System.out.println("  pay " + amount);
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be positive");
        }
        return "paid " + amount;
    }
}
