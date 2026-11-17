package labs.lab1_2.task3_cycle;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

// Takes card payments and remembers what each card has spent today.
@Service
public class CardService {

    private final LimitMonitor monitor;
    private final Map<String, Integer> spentToday = new HashMap<>();

    public CardService(LimitMonitor monitor) {
        this.monitor = monitor;
    }

    public String pay(String card, int amount) {
        if (!monitor.allows(card, amount)) {
            return "declined, " + spentToday(card) + " EUR spent today";
        }
        spentToday.merge(card, amount, Integer::sum);
        return "paid";
    }

    public int spentToday(String card) {
        return spentToday.getOrDefault(card, 0);
    }
}
