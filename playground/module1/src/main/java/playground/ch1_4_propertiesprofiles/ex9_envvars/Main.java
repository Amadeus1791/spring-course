package playground.ch1_4_propertiesprofiles.ex9_envvars;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;

// Start it three times: as it is, with ROBOT_NAME=Envy, and with ROBOT_NAME=Envy plus -Drobot.name=Sysy.
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        ConfigurableEnvironment env = context.getEnvironment();
        System.out.println("robot.name: " + env.getProperty("robot.name"));
        for (PropertySource<?> source : env.getPropertySources()) {
            System.out.println("  asked: " + source.getName());
        }
        context.close();
    }
}
