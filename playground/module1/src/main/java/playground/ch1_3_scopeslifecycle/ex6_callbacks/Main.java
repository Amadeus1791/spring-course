package playground.ch1_3_scopeslifecycle.ex6_callbacks;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        System.out.println("1. start");
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        System.out.println("2. work");
        System.out.println("3. close");
        context.close();
        System.out.println("4. closed");
    }
}
