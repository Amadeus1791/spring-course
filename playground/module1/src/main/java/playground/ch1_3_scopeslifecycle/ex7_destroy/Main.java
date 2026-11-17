package playground.ch1_3_scopeslifecycle.ex7_destroy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import playground.ch1_3_scopeslifecycle.ex7_destroy.closing.CloseConfig;

public class Main {

    public static void main(String[] args) {
        System.out.println("1. OrderConfig: start");
        AnnotationConfigApplicationContext first = new AnnotationConfigApplicationContext(OrderConfig.class);
        System.out.println("1. OrderConfig: close");
        first.close();

        System.out.println("2. CloseConfig: start and close");
        AnnotationConfigApplicationContext second = new AnnotationConfigApplicationContext(CloseConfig.class);
        second.close();
    }
}
