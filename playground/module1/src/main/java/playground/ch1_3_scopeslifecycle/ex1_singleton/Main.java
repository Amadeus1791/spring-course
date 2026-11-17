package playground.ch1_3_scopeslifecycle.ex1_singleton;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RobotConfig.class);
        Counter first = context.getBean(Counter.class);
        Counter second = context.getBean(Counter.class);

        first.increment();
        second.increment();

        System.out.println("Same object:  " + (first == second));
        System.out.println("Count:        " + first.getCount());
        context.close();
    }
}
