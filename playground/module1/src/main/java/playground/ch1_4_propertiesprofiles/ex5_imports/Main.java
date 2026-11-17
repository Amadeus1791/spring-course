package playground.ch1_4_propertiesprofiles.ex5_imports;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        // Only RobotConfig is registered. BatteryConfig comes in through @Import.
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RobotConfig.class);
        System.out.println("robot has a battery: " + (context.getBean(Robot.class).getBattery() != null));
        for (String name : context.getBeanDefinitionNames()) {
            if (!name.startsWith("org.")) {
                System.out.println("  " + name);
            }
        }
        context.close();
    }
}
