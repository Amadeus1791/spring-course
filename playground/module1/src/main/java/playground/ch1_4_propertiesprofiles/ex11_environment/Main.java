package playground.ch1_4_propertiesprofiles.ex11_environment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        ConfigurableEnvironment env = context.getEnvironment();
        System.out.println(env.getClass().getSimpleName());
        for (PropertySource<?> source : env.getPropertySources()) {
            System.out.println("  " + source.getName());
        }
        System.out.println("robot: " + context.getBean(Robot.class).getName());
        context.close();
    }
}
