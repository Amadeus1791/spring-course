package labs.lab2_2.task2_payments;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// Stores payments in the table card_payment.
@Repository
public class JdbcPaymentRepository implements PaymentRepository {

    private static final RowMapper<Payment> PAYMENT = (rs, rowNum) ->
            new Payment(rs.getString("card_number"), rs.getBigDecimal("amount"), rs.getString("merchant"));

    private final JdbcTemplate jdbc;

    public JdbcPaymentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void save(Payment payment) {
        jdbc.update("INSERT INTO card_payment (card_number, amount, merchant) VALUES (?, ?, ?)",
                payment.cardNumber(), payment.amount(), payment.merchant());
    }

    @Override
    public List<Payment> findByCard(String cardNumber) {
        return jdbc.query("SELECT card_number, amount, merchant FROM card_payment WHERE card_number = ? ORDER BY id",
                PAYMENT, cardNumber);
    }
}
