package playground.ch1_1_definingbeans.ex7_inside;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        System.out.println("1. new AnnotationConfigApplicationContext(...)");
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);

        System.out.println("2. All bean names:");
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println("   " + name);
        }

        BeanDefinition recipe = context.getBeanDefinition("robot");
        System.out.println("3. Recipe of robot: factory " + recipe.getFactoryBeanName() + "." + recipe.getFactoryMethodName()
                + "(), scope '" + recipe.getScope() + "', lazy " + recipe.isLazyInit());

        System.out.println("4. getBean(Robot.class)");
        context.getBean(Robot.class);

        System.out.println("5. close()");
        context.close();
        System.out.println("6. Active after close: " + context.isActive());
    }
}
