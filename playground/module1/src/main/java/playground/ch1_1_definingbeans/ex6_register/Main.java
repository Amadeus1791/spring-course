package playground.ch1_1_definingbeans.ex6_register;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // The name of the robot comes from somewhere at runtime, for example from the command line.
        String name = args.length > 0 ? args[0] : "Robo";
        Supplier<Robot> supplier = () -> new Robot(name);

        context.registerBean("robo", Robot.class, supplier);
        context.registerBean(Robot.class, () -> new Robot("Spare"), definition -> definition.setPrimary(true));
        context.refresh();

        System.out.println("Bean names: " + context.getBeansOfType(Robot.class).keySet());
        System.out.println("By type:    " + context.getBean(Robot.class).getName());
        context.close();
    }
}
