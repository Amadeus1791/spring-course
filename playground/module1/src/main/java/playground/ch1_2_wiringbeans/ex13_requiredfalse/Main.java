package playground.ch1_2_wiringbeans.ex13_requiredfalse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        System.out.println("1. a Battery bean, no Charger");
        try (var context = new AnnotationConfigApplicationContext(RobotConfig.WithBattery.class)) {
            System.out.println("  " + context.getBean(Robot.class).describe());
        }
        System.out.println("2. no Battery, no Charger");
        try (var context = new AnnotationConfigApplicationContext(RobotConfig.NoBattery.class)) {
            System.out.println("  " + context.getBean(Robot.class).describe());
        }
    }
}
