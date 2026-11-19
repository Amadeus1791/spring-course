package labs.lab2_2.task2_payments;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// Stores payments in the table card_payment (task2-schema.sql).
@Repository
public class JdbcPaymentRepository implements PaymentRepository {

    private final JdbcTemplate jdbc;

    public JdbcPaymentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // TODO Lab 2.2, task 2: store one payment
    @Override
    public void save(Payment payment) {
        throw new UnsupportedOperationException("Lab 2.2, task 2");
    }

    // TODO Lab 2.2, task 2: the payments of one card, the oldest first
    @Override
    public List<Payment> findByCard(String cardNumber) {
        throw new UnsupportedOperationException("Lab 2.2, task 2");
    }
}
