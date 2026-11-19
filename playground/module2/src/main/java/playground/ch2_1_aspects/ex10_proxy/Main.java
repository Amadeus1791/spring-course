package playground.ch2_1_aspects.ex10_proxy;

import org.springframework.aop.support.AopUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RobotConfig.class);
        var robot = context.getBean(Robot.class);

        System.out.println("class:       " + robot.getClass().getName());
        System.out.println("superclass:  " + robot.getClass().getSuperclass().getSimpleName());
        System.out.println("is a proxy:  " + AopUtils.isAopProxy(robot));

        // Who built the proxy? A bean that @EnableAspectJAutoProxy registered.
        for (String name : context.getBeanDefinitionNames()) {
            if (name.contains("AutoProxy")) {
                System.out.println("built by:    " + name);
                System.out.println("             " + context.getBean(name).getClass().getSimpleName());
            }
        }

        System.out.println("--- robot from the context");
        robot.move(3);
        System.out.println("--- robot made with new");
        new Robot().move(3);
        context.close();
    }
}
