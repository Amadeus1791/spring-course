package playground.ch1_2_wiringbeans.ex9_meta;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        System.out.println("Beans of type Mower:  " + context.getBeanNamesForType(Mower.class).length);
        System.out.println("Beans of type Vacuum: " + context.getBeanNamesForType(Vacuum.class).length);
        context.close();
    }
}
