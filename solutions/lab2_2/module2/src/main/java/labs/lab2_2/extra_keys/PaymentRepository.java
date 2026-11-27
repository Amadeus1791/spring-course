package labs.lab2_2.extra_keys;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository {

    private final JdbcTemplate jdbc;

    public PaymentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Stores the payment and returns the id the database gave it.
    public long save(Payment payment) {
        KeyHolder keys = new GeneratedKeyHolder();
        jdbc.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO card_payment (card_number, amount, merchant) VALUES (?, ?, ?)",
                    new String[] {"id"});
            statement.setString(1, payment.cardNumber());
            statement.setBigDecimal(2, payment.amount());
            statement.setString(3, payment.merchant());
            return statement;
        }, keys);
        return keys.getKey().longValue();
    }

    public BigDecimal amountOf(long id) {
        return jdbc.queryForObject("SELECT amount FROM card_payment WHERE id = ?", BigDecimal.class, id);
    }
}
