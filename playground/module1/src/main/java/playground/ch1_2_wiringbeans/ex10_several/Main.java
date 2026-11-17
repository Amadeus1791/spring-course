package playground.ch1_2_wiringbeans.ex10_several;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(RobotConfig.class)) {
            var dashboard = context.getBean(Dashboard.class);
            System.out.println("List: " + dashboard.batteries());
            System.out.println("Map:  " + dashboard.batteriesByName().keySet());
        }
    }
}
