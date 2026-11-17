package playground.ch1_1_definingbeans.ex9_scanoptions;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import playground.ch1_1_definingbeans.ex9_scanoptions.garage.Robot;
import playground.ch1_1_definingbeans.ex9_scanoptions.garage.parts.Battery;
import playground.ch1_1_definingbeans.ex9_scanoptions.tools.Wrench;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(WorkshopConfig.class);

        Class<?>[] classes = {Robot.class, Battery.class, Wrench.class};
        for (Class<?> type : classes) {
            try {
                context.getBean(type);
                System.out.println(type.getSimpleName() + ": a bean");
            } catch (RuntimeException e) {
                System.out.println(type.getSimpleName() + ": " + e.getClass().getSimpleName());
            }
        }
        context.close();
    }
}
