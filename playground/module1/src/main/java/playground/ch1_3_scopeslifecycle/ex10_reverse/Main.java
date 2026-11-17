package playground.ch1_3_scopeslifecycle.ex10_reverse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);

        var first = context.getBean(Drone.class);
        var second = context.getBean(Drone.class);
        System.out.println(first.describe());
        System.out.println(second.describe());
        System.out.println("Two drones: " + (first != second));
        context.close();
    }
}
