package playground.ch1_2_wiringbeans.ex3_field;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        var robot = context.getBean(Robot.class);
        System.out.println("field injection, battery: " + robot.getBattery().getType());

        var byHand = new Robot();
        System.out.println("created with new, battery: " + (byHand.getBattery() == null ? "null" : byHand.getBattery().getType()));
        context.close();
    }
}
