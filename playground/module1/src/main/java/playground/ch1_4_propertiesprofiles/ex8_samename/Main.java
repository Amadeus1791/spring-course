package playground.ch1_4_propertiesprofiles.ex8_samename;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(HomeConfig.class, FactoryConfig.class);
        System.out.println("robots: " + context.getBeanNamesForType(Robot.class).length);
        System.out.println("robot:  " + context.getBean(Robot.class).getName());
        context.close();

        var swapped = new AnnotationConfigApplicationContext(FactoryConfig.class, HomeConfig.class);
        System.out.println("swapped, robot: " + swapped.getBean(Robot.class).getName());
        swapped.close();

        var strict = new AnnotationConfigApplicationContext();
        strict.setAllowBeanDefinitionOverriding(false);
        strict.register(HomeConfig.class, FactoryConfig.class);
        try {
            strict.refresh();
        } catch (RuntimeException e) {
            System.out.println("overriding off: " + e.getClass().getSimpleName());
            System.out.println("  " + e.getMessage());
        }
    }
}
