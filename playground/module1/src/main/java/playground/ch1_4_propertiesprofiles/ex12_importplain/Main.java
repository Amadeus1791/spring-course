package playground.ch1_4_propertiesprofiles.ex12_importplain;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        System.out.println("clock says: " + context.getBean(Clock.class).time());
        for (String name : context.getBeanDefinitionNames()) {
            if (!name.startsWith("org.")) {
                System.out.println("  " + name);
            }
        }
        context.close();
    }
}
