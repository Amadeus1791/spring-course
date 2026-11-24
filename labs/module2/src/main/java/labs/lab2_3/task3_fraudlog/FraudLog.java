package labs.lab2_3.task3_fraudlog;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// The fraud team reads the table declined_payment.
@Repository
public class FraudLog {

    private final JdbcTemplate jdbcTemplate;

    public FraudLog(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void record(String cardNumber, BigDecimal amount) {
        jdbcTemplate.update("INSERT INTO declined_payment (card_number, amount) VALUES (?, ?)", cardNumber, amount);
    }

    public List<String> entries() {
        return jdbcTemplate.query("SELECT card_number, amount FROM declined_payment ORDER BY id",
                (rs, rowNum) -> rs.getString("card_number") + " " + rs.getBigDecimal("amount"));
    }
}
