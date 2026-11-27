package labs.lab2_2.task4_jdbcclient;

import java.math.BigDecimal;

// One card payment.
public record Payment(String cardNumber, BigDecimal amount, String merchant) {
}
