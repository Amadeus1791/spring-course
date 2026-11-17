package labs.lab1_2.task1_authorizer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 1.2, task 1. Do not change this class.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardConfig.class)) {
            CardAuthorizer authorizer = context.getBean(CardAuthorizer.class);

            int[] amounts = {120, 6000, 80, 50};
            for (int amount : amounts) {
                System.out.printf("4242 pays %4d EUR: %s%n", amount, authorizer.authorize("4242", amount));
            }
        }
    }
}
