package playground.ch1_2_wiringbeans.ex2_parameter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(RobotConfig.class, BatteryConfig.class);

        Robot robo = context.getBean(Robot.class);
        System.out.println("Battery of Robo: " + robo.getBattery().getType());
        System.out.println("It is the bean:  " + (robo.getBattery() == context.getBean(Battery.class)));
        context.close();
    }
}
