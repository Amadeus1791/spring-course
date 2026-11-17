package playground.ch1_2_wiringbeans.ex5_constructor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RobotConfig.class);
        Robot robot = context.getBean(Robot.class);
        System.out.println("constructor injection, battery: " + robot.getBattery().getType());

        Robot byHand = new Robot(new Battery());
        System.out.println("created with new, battery: " + (byHand.getBattery() == null ? "null" : byHand.getBattery().getType()));
        context.close();
    }
}
