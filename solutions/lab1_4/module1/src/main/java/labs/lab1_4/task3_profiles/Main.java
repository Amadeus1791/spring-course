package labs.lab1_4.task3_profiles;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 1.4, task 3. Predict first, then run.
public class Main {

    public static void main(String[] args) {
        run();
        run("dev");
        run("prod");
    }

    private static void run(String... profiles) {
        try (var context = new AnnotationConfigApplicationContext()) {
            context.getEnvironment().setActiveProfiles(profiles);
            context.register(CardConfig.class);
            context.refresh();
            System.out.println(List.of(profiles) + ": " + ownBeans(context));
        }
    }

    // The beans of the context, without the configurations and Spring's own beans.
    private static List<String> ownBeans(AnnotationConfigApplicationContext context) {
        List<String> names = new ArrayList<>();
        for (String name : context.getBeanDefinitionNames()) {
            if (!name.startsWith("org.springframework") && !name.endsWith("Config")) {
                names.add(name);
            }
        }
        return names;
    }
}
