package labs.lab1_2.task3_cycle;

import org.springframework.stereotype.Service;

// Takes card payments.
@Service
public class CardService {

    private final LimitMonitor monitor;
    private final DailySpending spending;

    public CardService(LimitMonitor monitor, DailySpending spending) {
        this.monitor = monitor;
        this.spending = spending;
    }

    public String pay(String card, int amount) {
        if (!monitor.allows(card, amount)) {
            return "declined, " + spending.spentToday(card) + " EUR spent today";
        }
        spending.record(card, amount);
        return "paid";
    }
}
