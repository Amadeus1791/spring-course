package playground.ch1_1_definingbeans.ex5_scan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import playground.ch1_1_definingbeans.ex5_scan.garage.GarageConfig;
import playground.ch1_1_definingbeans.ex5_scan.garage.Robot;
import playground.ch1_1_definingbeans.ex5_scan.garage.parts.Battery;
import playground.ch1_1_definingbeans.ex5_scan.tools.Wrench;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GarageConfig.class);

        Class<?>[] classes = {Robot.class, Battery.class, Wrench.class};
        for (Class<?> type : classes) {
            String where = type.getPackageName().replace("playground.ch1_1_definingbeans.ex5_scan.", "");
            try {
                context.getBean(type);
                System.out.println(type.getSimpleName() + " in " + where + ": a bean");
            } catch (RuntimeException e) {
                System.out.println(type.getSimpleName() + " in " + where + ": " + e.getClass().getSimpleName());
            }
        }
        context.close();
    }
}
