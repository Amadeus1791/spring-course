package playground.ch1_1_definingbeans.ex3_twobeans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);

        System.out.println("By name: " + context.getBean("rusty", Robot.class).getName());
        System.out.println("All robots: " + context.getBeansOfType(Robot.class).keySet());
        try {
            context.getBean(Robot.class);
        } catch (RuntimeException e) {
            System.out.println("By type: " + e.getClass().getSimpleName());
            System.out.println("  " + e.getMessage());
        }
        context.close();
    }
}
