package playground.ch1_2_wiringbeans.ex7_circular;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        try {
            new AnnotationConfigApplicationContext(RobotConfig.class);
        } catch (RuntimeException e) {
            Throwable root = e;
            while (root.getCause() != null) {
                root = root.getCause();
            }
            System.out.println("Outer: " + e.getClass().getSimpleName());
            System.out.println("Root:  " + root.getClass().getSimpleName());
            System.out.println("  " + root.getMessage());
        }
    }
}
