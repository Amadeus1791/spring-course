package playground.ch1_1_definingbeans.ex8_lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// The four phases of a context: register, refresh, use, close. What does getBean answer in between?
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext();
        context.register(RobotConfig.class);

        System.out.println("getBean() before refresh():");
        tryGetBean(context);

        context.refresh();
        System.out.println("getBean() after refresh():");
        tryGetBean(context);

        context.close();
        System.out.println("getBean() after close():");
        tryGetBean(context);
    }

    private static void tryGetBean(AnnotationConfigApplicationContext context) {
        try {
            System.out.println("  " + context.getBean(Robot.class).getName());
        } catch (RuntimeException e) {
            System.out.println("  " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}
