package labs.lab2_1.task2_timing;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 2.1, task 2. Do not change this class.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardConfig.class)) {
            CardService cards = context.getBean(CardService.class);
            System.out.println(cards.pay(100));
            System.out.println(cards.refund(30));
            System.out.println("balance " + cards.balance());
            try {
                cards.pay(-5);
            } catch (IllegalArgumentException e) {
                System.out.println("declined: " + e.getMessage());
            }
            System.out.println("Timed: " + context.getBean(MethodTimings.class).timed());
        }
    }
}
