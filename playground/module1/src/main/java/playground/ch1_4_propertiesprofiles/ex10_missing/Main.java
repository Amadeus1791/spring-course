package playground.ch1_4_propertiesprofiles.ex10_missing;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import playground.ch1_4_propertiesprofiles.ex1_source.RobotConfig;

// Question 2 of chapter 1.4: a key that is not in robot.properties.
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RobotConfig.class);
        Environment env = context.getEnvironment();

        System.out.println("getProperty:          " + env.getProperty("robot.color"));
        System.out.println("getProperty, default: " + env.getProperty("robot.color", "grey"));
        try {
            env.getRequiredProperty("robot.color");
        } catch (IllegalStateException e) {
            System.out.println("getRequiredProperty:  " + e.getClass().getSimpleName());
            System.out.println("  " + e.getMessage());
        }
        context.close();
    }
}
