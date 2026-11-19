package playground.ch2_1_aspects.ex3_returning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        var robot = context.getBean(Robot.class);
        robot.move(3);
        try {
            robot.move(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("caller caught: " + e.getMessage());
        }
        context.close();
    }
}
