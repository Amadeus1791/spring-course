package labs.lab2_3.extra_dryrun;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 2.3, extra task. Do not change this class.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardDataConfig.class)) {
            LimitService limits = context.getBean(LimitService.class);
            System.out.println("Simulated: " + limits.simulate("4242", 8000));
            System.out.println("Stored:    " + limits.limitOf("4242"));
        }
    }
}
