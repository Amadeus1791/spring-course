package playground.ch1_1_definingbeans.ex3b_aliases;

import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(RobotConfig.class)) {
            Robot robo = context.getBean("robo", Robot.class);
            System.out.println("robbie is robo: " + (context.getBean("robbie") == robo));
            System.out.println("r2 is robo:     " + (context.getBean("r2") == robo));
            System.out.println("Aliases of robo: " + Arrays.toString(context.getAliases("robo")));

            // A name added in code, after the start.
            context.registerAlias("robo", "tin");
            System.out.println("tin is robo:    " + (context.getBean("tin") == robo));
        }
    }
}
