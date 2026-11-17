package labs.lab1_2.task3_cycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 1.2, task 3. Do not change this class.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardConfig.class)) {
            CardService cards = context.getBean(CardService.class);

            int[] amounts = {50, 300, 200};
            for (int amount : amounts) {
                System.out.printf("%3d EUR: %s%n", amount, cards.pay("4242", amount));
            }
        }
    }
}
