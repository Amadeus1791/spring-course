package labs.lab2_2.extra_keys;

import java.math.BigDecimal;

// One card payment, still without its id.
public record Payment(String cardNumber, BigDecimal amount, String merchant) {
}
