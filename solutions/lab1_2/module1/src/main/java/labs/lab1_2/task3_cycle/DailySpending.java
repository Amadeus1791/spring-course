package labs.lab1_2.task3_cycle;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

// What each card has spent today. Both CardService and LimitMonitor need this knowledge,
// so it moves into a class of its own: the cycle is gone.
@Component
public class DailySpending {

    private final Map<String, Integer> spentToday = new HashMap<>();

    public void record(String card, int amount) {
        spentToday.merge(card, amount, Integer::sum);
    }

    public int spentToday(String card) {
        return spentToday.getOrDefault(card, 0);
    }
}
