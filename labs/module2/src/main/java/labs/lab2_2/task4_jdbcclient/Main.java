package labs.lab2_2.task4_jdbcclient;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 2.2, task 4. Do not change this class.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardDataConfig.class)) {
            for (Payment payment : context.getBean(ClientPaymentRepository.class).findByCard("4242")) {
                System.out.println(payment);
            }
        }
    }
}
