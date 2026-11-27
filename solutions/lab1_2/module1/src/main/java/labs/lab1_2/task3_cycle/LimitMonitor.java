package labs.lab1_2.task3_cycle;

import org.springframework.stereotype.Component;

// Allows a payment only while the card stays within its daily limit of 500 EUR.
@Component
public class LimitMonitor {

    private static final int DAILY_LIMIT = 500;

    private final DailySpending spending;

    public LimitMonitor(DailySpending spending) {
        this.spending = spending;
    }

    public boolean allows(String card, int amount) {
        return spending.spentToday(card) + amount <= DAILY_LIMIT;
    }
}
