package playground.ch1_3_scopeslifecycle.ex8_bfpp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RobotConfig.class);
        Robot first = context.getBean(Robot.class);
        Robot second = context.getBean(Robot.class);
        System.out.println("Same robot twice: " + (first == second));
        context.close();
    }
}
