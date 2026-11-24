package labs.lab2_3.task3_fraudlog;

import java.math.BigDecimal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {

    private final JdbcTemplate jdbcTemplate;
    private final FraudLog fraudLog;

    public PaymentService(JdbcTemplate jdbcTemplate, FraudLog fraudLog) {
        this.jdbcTemplate = jdbcTemplate;
        this.fraudLog = fraudLog;
    }

    // Adds the amount to what the card spent today. Above the daily limit: declined.
    @Transactional
    public void authorize(String cardNumber, BigDecimal amount) {
        jdbcTemplate.update("UPDATE card SET spent_today = spent_today + ? WHERE number = ?", amount, cardNumber);
        BigDecimal spent = jdbcTemplate.queryForObject(
                "SELECT spent_today FROM card WHERE number = ?", BigDecimal.class, cardNumber);
        BigDecimal limit = jdbcTemplate.queryForObject(
                "SELECT daily_limit FROM card WHERE number = ?", BigDecimal.class, cardNumber);
        if (spent.compareTo(limit) > 0) {
            fraudLog.record(cardNumber, amount);
            throw new IllegalStateException("declined, daily limit " + limit);
        }
    }
}
