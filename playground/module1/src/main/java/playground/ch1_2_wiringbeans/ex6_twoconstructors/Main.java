package playground.ch1_2_wiringbeans.ex6_twoconstructors;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        System.out.println("1. Robot:");
        var first = new AnnotationConfigApplicationContext(Battery.class, Robot.class);
        Robot robot = first.getBean(Robot.class);
        System.out.println("  battery: " + (robot.getBattery() == null ? "null" : robot.getBattery().getType()));
        first.close();

        System.out.println("2. MarkedRobot:");
        var second = new AnnotationConfigApplicationContext(Battery.class, MarkedRobot.class);
        MarkedRobot marked = second.getBean(MarkedRobot.class);
        System.out.println("  battery: " + (marked.getBattery() == null ? "null" : marked.getBattery().getType()));
        second.close();

        System.out.println("3. TwoChoicesRobot:");
        try {
            new AnnotationConfigApplicationContext(Battery.class, Charger.class, TwoChoicesRobot.class);
        } catch (RuntimeException e) {
            System.out.println("  " + e.getClass().getSimpleName());
            System.out.println("  " + e.getMessage());
        }
    }
}
