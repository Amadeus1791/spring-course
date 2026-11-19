package labs.lab2_2.extra_keys;

import java.math.BigDecimal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository {

    private final JdbcTemplate jdbc;

    public PaymentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Stores the payment and returns the id the database gave it.
    // TODO Lab 2.2, extra task
    public long save(Payment payment) {
        throw new UnsupportedOperationException("Lab 2.2, extra task");
    }

    public BigDecimal amountOf(long id) {
        return jdbc.queryForObject("SELECT amount FROM card_payment WHERE id = ?", BigDecimal.class, id);
    }
}
