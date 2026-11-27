package labs.lab2_3.task3_fraudlog;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

// Lab 2.3, task 3. Do not change this class.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardDataConfig.class)) {
            PaymentService payments = context.getBean(PaymentService.class);
            JdbcTemplate jdbc = context.getBean(JdbcTemplate.class);

            authorize(payments, "4242", "120.00");
            authorize(payments, "4242", "9000.00");
            authorize(payments, "5555", "1500.00");

            List<String> spent = jdbc.query("SELECT number, spent_today FROM card ORDER BY number",
                    (rs, rowNum) -> rs.getString("number") + " " + rs.getBigDecimal("spent_today"));
            System.out.println("spent today:      " + spent);
            System.out.println("declined on file: " + context.getBean(FraudLog.class).entries());
        }
    }

    private static void authorize(PaymentService payments, String cardNumber, String amount) {
        String outcome = "approved";
        try {
            payments.authorize(cardNumber, new BigDecimal(amount));
        } catch (RuntimeException e) {
            outcome = e.getMessage();
        }
        System.out.println(cardNumber + " pays " + amount + ": " + outcome);
    }
}
