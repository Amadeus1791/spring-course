package playground.ch1_4_propertiesprofiles.ex1_source;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RobotConfig.class);
        Environment environment = context.getEnvironment();

        String name = environment.getProperty("robot.name");
        Integer speed = environment.getProperty("robot.speed", Integer.class);
        String color = environment.getProperty("robot.color");
        String colorOrDefault = environment.getProperty("robot.color", "grey");

        System.out.println("robot.name:            " + name);
        System.out.println("robot.speed * 2:       " + speed * 2);
        System.out.println("robot.color:           " + color);
        System.out.println("robot.color, default:  " + colorOrDefault);
        context.close();
    }
}
