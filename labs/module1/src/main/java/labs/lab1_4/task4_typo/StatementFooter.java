package labs.lab1_4.task4_typo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// The last lines of the monthly card statement.
@Component
public class StatementFooter {

    private final String dailyLimit;
    private final String statementDay;

    public StatementFooter(@Value("${card.daily.limt}") String dailyLimit,
                           @Value("${card.statement.day}") String statementDay) {
        this.dailyLimit = dailyLimit;
        this.statementDay = statementDay;
    }

    public String text() {
        return "Daily limit: " + dailyLimit + ", next statement on day " + statementDay;
    }
}
