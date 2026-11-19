package playground.ch1_3_scopeslifecycle.ex12_wholelife;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// The whole life of one bean, in one run.
public class Main {

    public static void main(String[] args) {
        System.out.println("--- new AnnotationConfigApplicationContext(...)");
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        System.out.println("--- in use");
        context.getBean(Robot.class).work();
        System.out.println("--- context.close()");
        context.close();
    }
}
