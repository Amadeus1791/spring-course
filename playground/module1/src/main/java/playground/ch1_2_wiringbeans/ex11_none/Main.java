package playground.ch1_2_wiringbeans.ex11_none;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.NestedExceptionUtils;

public class Main {

    public static void main(String[] args) {
        System.out.println("1. Strict: a plain Battery parameter");
        try (var context = new AnnotationConfigApplicationContext(RobotConfig.Strict.class)) {
            System.out.println("  started");
        } catch (RuntimeException e) {
            var root = NestedExceptionUtils.getMostSpecificCause(e);
            System.out.println("  Outer: " + e.getClass().getSimpleName());
            System.out.println("  Root:  " + root.getClass().getSimpleName());
            System.out.println("  " + root.getMessage());
        }
        System.out.println("2. Tolerant: three ways to say optional");
        try (var context = new AnnotationConfigApplicationContext(RobotConfig.Tolerant.class)) {
            var dashboard = context.getBean(Dashboard.class);
            System.out.println("  Optional:       " + dashboard.battery());
            System.out.println("  getIfAvailable: " + dashboard.batteries().getIfAvailable());
            System.out.println("  required=false: " + context.getBean(Panel.class).battery());
        }
    }
}
