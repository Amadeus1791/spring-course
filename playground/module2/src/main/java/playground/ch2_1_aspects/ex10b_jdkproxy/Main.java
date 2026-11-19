package playground.ch2_1_aspects.ex10b_jdkproxy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- RobotConfig: the robot implements Movable");
        show(RobotConfig.class);
        System.out.println("--- ClassProxyConfig: proxyTargetClass = true");
        show(ClassProxyConfig.class);
    }

    static void show(Class<?> config) {
        var context = new AnnotationConfigApplicationContext(config, Robot.class, LogAspect.class);
        Movable movable = context.getBean(Movable.class);
        System.out.println("class:               " + movable.getClass().getSimpleName());
        System.out.println("instanceof Movable:  " + (movable instanceof Movable));
        System.out.println("instanceof Robot:    " + (movable instanceof Robot));
        movable.move(3);
        try {
            context.getBean(Robot.class);
            System.out.println("getBean(Robot.class): works");
        } catch (RuntimeException e) {
            System.out.println("getBean(Robot.class): " + e.getClass().getSimpleName());
        }
        context.close();
    }
}
