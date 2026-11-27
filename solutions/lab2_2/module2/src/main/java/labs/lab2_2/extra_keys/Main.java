package labs.lab2_2.extra_keys;

import java.math.BigDecimal;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 2.2, extra task. Do not change this class.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardDataConfig.class)) {
            PaymentRepository payments = context.getBean(PaymentRepository.class);
            long bakery = payments.save(new Payment("4242", new BigDecimal("12.50"), "Bakery"));
            long fuel = payments.save(new Payment("5555", new BigDecimal("80.00"), "Fuel"));
            System.out.println("Bakery: id " + bakery + ", amount " + payments.amountOf(bakery));
            System.out.println("Fuel:   id " + fuel + ", amount " + payments.amountOf(fuel));
        }
    }
}
