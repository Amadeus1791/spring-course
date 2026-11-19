package labs.lab2_2.task3_figures;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

// Figures for the management. Each method: one JdbcTemplate call, each with a different method.
@Component
public class CardReport {

    private final JdbcTemplate jdbc;

    public CardReport(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // TODO Lab 2.2, task 3a: the sum of all daily limits
    public int totalLimit() {
        throw new UnsupportedOperationException("Lab 2.2, task 3a");
    }

    // TODO Lab 2.2, task 3b: the card numbers with a daily limit above the minimum, sorted by number
    public List<String> cardsAbove(int minimum) {
        throw new UnsupportedOperationException("Lab 2.2, task 3b");
    }

    // TODO Lab 2.2, task 3c: holder to the sum of the limits of all their cards, sorted by holder
    public Map<String, Integer> limitByHolder() {
        throw new UnsupportedOperationException("Lab 2.2, task 3c");
    }
}
