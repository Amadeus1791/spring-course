package labs.lab2_1.extra_order;

import org.springframework.stereotype.Service;

@Service
public class CardService {

    public String pay(int amount) {
        System.out.println("      pay " + amount);
        return "paid " + amount;
    }
}
