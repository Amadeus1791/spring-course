package labs.lab1_3.task3_wrapper;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 1.3, task 3. Do not change this class.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardConfig.class)) {
            CardNotifier notifier = context.getBean(CardNotifier.class);
            notifier.send("Card 4242424242424242 blocked");
            System.out.println("Bean class: " + notifier.getClass().getSimpleName());

            System.out.println("Lookup by class SmsNotifier:");
            try {
                Object bean = context.getBean(SmsNotifier.class);
                System.out.println("   a bean of class " + bean.getClass().getSimpleName());
            } catch (RuntimeException e) {
                System.out.println("   " + e.getClass().getSimpleName());
                System.out.println("   " + e.getMessage());
            }
        }
    }
}
