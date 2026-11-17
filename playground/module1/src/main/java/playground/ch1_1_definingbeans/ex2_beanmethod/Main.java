package playground.ch1_1_definingbeans.ex2_beanmethod;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RobotConfig.class);

        Robot robot = context.getBean(Robot.class);
        System.out.println("By type:  " + robot.getName());
        System.out.println("By name:  " + context.getBean("robot", Robot.class).getName());
        System.out.println("A String: " + context.getBean(String.class));
        System.out.println("Same object twice: " + (robot == context.getBean(Robot.class)));
        context.close();
    }
}
