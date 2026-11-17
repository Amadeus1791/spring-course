package playground.ch1_1_definingbeans.ex4_stereotype;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);

        var robot = context.getBean(Robot.class);
        System.out.println("Name of the bean:  " + context.getBeanNamesForType(Robot.class)[0]);
        System.out.println("Name of the robot: " + robot.getName());
        context.close();
    }
}
