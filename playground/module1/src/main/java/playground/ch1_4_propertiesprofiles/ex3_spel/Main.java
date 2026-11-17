package playground.ch1_4_propertiesprofiles.ex3_spel;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RobotConfig.class);
        System.out.println(context.getBean(Robot.class).describe());
        context.close();
    }
}
