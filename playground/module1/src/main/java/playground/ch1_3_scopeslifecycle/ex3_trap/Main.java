package playground.ch1_3_scopeslifecycle.ex3_trap;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RobotConfig.class);

        Robot robot = context.getBean(Robot.class);
        robot.newTask().add("clean");
        System.out.println("Robot, second task:      " + robot.newTask().getSteps());

        FixedRobot fixed = context.getBean(FixedRobot.class);
        fixed.newTask().add("clean");
        System.out.println("FixedRobot, second task: " + fixed.newTask().getSteps());
        context.close();
    }
}
