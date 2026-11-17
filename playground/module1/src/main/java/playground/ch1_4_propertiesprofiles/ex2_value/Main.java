package playground.ch1_4_propertiesprofiles.ex2_value;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RobotConfig.class);
        Robot robot = context.getBean(Robot.class);
        System.out.println(robot.describe());
        context.close();
    }
}
