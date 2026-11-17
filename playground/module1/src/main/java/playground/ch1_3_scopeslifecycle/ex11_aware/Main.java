package playground.ch1_3_scopeslifecycle.ex11_aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        System.out.println("1. start");
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        System.out.println("2. injected instead");
        var navigator = context.getBean(Navigator.class);
        System.out.println("  Navigator got the context: " + (navigator.getContext() == context));
        context.close();
    }
}
