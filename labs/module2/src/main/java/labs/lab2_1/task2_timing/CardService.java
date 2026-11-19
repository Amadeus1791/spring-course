package labs.lab2_1.task2_timing;

import org.springframework.stereotype.Service;

// TODO Lab 2.1, task 2: time pay and refund, but not balance
@Service
public class CardService {

    public String pay(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be positive");
        }
        return "paid " + amount;
    }

    public String refund(int amount) {
        return "refunded " + amount;
    }

    public int balance() {
        return 250;
    }
}
