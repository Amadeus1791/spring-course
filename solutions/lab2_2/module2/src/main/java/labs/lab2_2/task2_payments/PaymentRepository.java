package labs.lab2_2.task2_payments;

import java.util.List;

public interface PaymentRepository {

    void save(Payment payment);

    // The payments of one card, the oldest first.
    List<Payment> findByCard(String cardNumber);
}
