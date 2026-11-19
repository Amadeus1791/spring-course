package playground.ch2_1_aspects.ex5_change;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        var robot = context.getBean(Robot.class);
        System.out.println("move(3):  " + robot.move(3));
        System.out.println("move(25): " + robot.move(25));
        context.close();
    }
}
