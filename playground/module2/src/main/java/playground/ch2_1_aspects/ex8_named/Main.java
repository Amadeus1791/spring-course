package playground.ch2_1_aspects.ex8_named;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        var robot = context.getBean(Robot.class);
        robot.move(3);
        robot.turn("left");
        robot.charge(80);
        context.close();
    }
}
