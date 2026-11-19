package labs.lab2_1.task1_advice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 2.1, task 1. Predict first, then run.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardConfig.class)) {
            CardPayments payments = context.getBean(CardPayments.class);
            call("A", () -> payments.pay(100));
            call("B", () -> payments.pay(-5));
        }
    }

    private static void call(String label, java.util.function.Supplier<String> payment) {
        System.out.println(label + ":");
        try {
            System.out.println("  caller got: " + payment.get());
        } catch (RuntimeException e) {
            System.out.println("  caller got " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}
