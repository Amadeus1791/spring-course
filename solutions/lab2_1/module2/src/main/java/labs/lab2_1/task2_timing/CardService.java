package labs.lab2_1.task2_timing;

import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Timed
    public String pay(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be positive");
        }
        return "paid " + amount;
    }

    @Timed
    public String refund(int amount) {
        return "refunded " + amount;
    }

    public int balance() {
        return 250;
    }
}
