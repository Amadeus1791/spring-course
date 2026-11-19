package labs.lab2_1.extra_order;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 2.1, extra task. Do not change this class.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardConfig.class)) {
            CardService cards = context.getBean(CardService.class);
            System.out.println(cards.pay(100));
        }
    }
}
