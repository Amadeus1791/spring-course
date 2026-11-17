package labs.lab1_2.task3_cycle;

import org.springframework.stereotype.Component;

// Allows a payment only while the card stays within its daily limit of 500 EUR.
@Component
public class LimitMonitor {

    private static final int DAILY_LIMIT = 500;

    private final CardService cardService;

    public LimitMonitor(CardService cardService) {
        this.cardService = cardService;
    }

    public boolean allows(String card, int amount) {
        return cardService.spentToday(card) + amount <= DAILY_LIMIT;
    }
}
