package playground.ch1_2_wiringbeans.ex1_methodcall;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);

        Robot robo = context.getBean("robo", Robot.class);
        Robot rusty = context.getBean("rusty", Robot.class);
        System.out.println("Batteries:    " + Battery.created());
        System.out.println("Shared:       " + (robo.getBattery() == rusty.getBattery()));
        System.out.println("Is the bean:  " + (robo.getBattery() == context.getBean(Battery.class)));
        String configClass = context.getBean(RobotConfig.class).getClass().getSimpleName();
        System.out.println("Config class: " + configClass);
        context.close();
    }
}
