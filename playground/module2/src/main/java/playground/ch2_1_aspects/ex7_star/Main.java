package playground.ch2_1_aspects.ex7_star;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        var robot = context.getBean(Robot.class);
        var dock = context.getBean(Dock.class);
        robot.move(3);
        robot.turn("left");
        robot.stop();
        dock.charge(80);
        context.close();
    }
}
