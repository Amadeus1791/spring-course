package labs.lab2_2.task2_payments;

import java.math.BigDecimal;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 2.2, task 2. Do not change this class.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardDataConfig.class)) {
            PaymentRepository payments = context.getBean(PaymentRepository.class);
            payments.save(new Payment("4242", new BigDecimal("12.50"), "Bakery"));
            payments.save(new Payment("5555", new BigDecimal("80.00"), "Fuel"));
            payments.save(new Payment("4242", new BigDecimal("199.90"), "Shoes"));

            for (Payment payment : payments.findByCard("4242")) {
                System.out.println(payment);
            }
        }
    }
}
