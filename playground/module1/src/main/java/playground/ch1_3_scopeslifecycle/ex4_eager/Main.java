package playground.ch1_3_scopeslifecycle.ex4_eager;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        System.out.println("1. start the context");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RobotConfig.class);
        System.out.println("2. context started");
        context.getBean(LazyRobot.class);
        System.out.println("3. LazyRobot fetched");
        context.close();
    }
}
