package playground.ch1_3_scopeslifecycle.ex2_prototype;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        var first = context.getBean(Counter.class);
        var second = context.getBean(Counter.class);

        first.increment();
        second.increment();

        System.out.println("Same object:  " + (first == second));
        System.out.println("Count:        " + first.getCount());
        context.close();
    }
}
