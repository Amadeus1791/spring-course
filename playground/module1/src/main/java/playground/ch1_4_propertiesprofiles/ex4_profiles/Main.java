package playground.ch1_4_propertiesprofiles.ex4_profiles;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        print("home");
        print("factory");
        print();
    }

    private static void print(String... profiles) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles(profiles);   // before refresh
        context.register(RobotConfig.class);
        context.refresh();
        System.out.println(String.format("%-20s", "profiles " + List.of(profiles) + ":") + beans(context));
        context.close();
    }

    // our beans only, without the internal ones and without robotConfig
    private static List<String> beans(AnnotationConfigApplicationContext context) {
        List<String> names = new ArrayList<>();
        for (String name : context.getBeanDefinitionNames()) {
            if (!name.startsWith("org.") && !name.equals("robotConfig")) {
                names.add(name);
            }
        }
        return names;
    }
}
