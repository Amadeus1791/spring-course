package playground.ch1_2_wiringbeans.ex3_field;

import java.lang.reflect.Field;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        var robot = context.getBean(Robot.class);
        System.out.println("field injection, battery: " + robot.getBattery().getType());

        var byHand = new Robot();
        System.out.println("created with new, battery: " + (byHand.getBattery() == null ? "null" : byHand.getBattery().getType()));
        try {
            byHand.getBattery().getType();
        } catch (NullPointerException e) {
            System.out.println("first use: " + e.getClass().getSimpleName());
        }

        // Filled by hand: the field is private and has no setter, so only reflection gets in.
        Field field = Robot.class.getDeclaredField("battery");
        field.setAccessible(true);
        field.set(byHand, new Battery());
        System.out.println("filled by reflection, battery: " + byHand.getBattery().getType());
        context.close();
    }
}
