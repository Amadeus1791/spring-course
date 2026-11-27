package labs.lab1_3.task2_prototype;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 1.3, task 2. Do not change this class.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardConfig.class)) {
            PaymentProcessor processor = context.getBean(PaymentProcessor.class);
            System.out.println("Payment 1: " + processor.process("4242", 120));
            System.out.println("Payment 2: " + processor.process("5555", 80));
        }
    }
}
