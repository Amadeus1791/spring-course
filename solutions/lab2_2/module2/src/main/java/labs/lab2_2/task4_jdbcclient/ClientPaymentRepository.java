package labs.lab2_2.task4_jdbcclient;

import java.util.List;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

// The payments, read with JdbcClient: no RowMapper, the columns are mapped by name.
@Repository
public class ClientPaymentRepository {

    private final JdbcClient jdbc;

    public ClientPaymentRepository(JdbcClient jdbc) {
        this.jdbc = jdbc;
    }

    public List<Payment> findByCard(String cardNumber) {
        return jdbc.sql("SELECT card_number, amount, merchant_name AS merchant FROM card_payment"
                        + " WHERE card_number = :card ORDER BY id")
                .param("card", cardNumber)
                .query(Payment.class)
                .list();
    }
}
