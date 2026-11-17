package playground.ch1_2_wiringbeans.ex12_inject;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(RobotConfig.class)) {
            System.out.println("Batteries: " + Arrays.toString(context.getBeanNamesForType(Battery.class)));
            System.out.println("Robot:     " + context.getBean(Robot.class).battery().type());
        }
    }
}
