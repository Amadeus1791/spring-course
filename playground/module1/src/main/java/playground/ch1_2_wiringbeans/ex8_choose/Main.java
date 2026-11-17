package playground.ch1_2_wiringbeans.ex8_choose;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(RobotConfig.WithPrimary.class)) {
            System.out.println("Robo:  " + context.getBean("robo", Robot.class).battery().type());
        }
        try (var context = new AnnotationConfigApplicationContext(RobotConfig.WithQualifier.class)) {
            System.out.println("Rusty: " + context.getBean("rusty", Robot.class).battery().type());
        }
    }
}
