package playground.ch2_1_aspects.ex11_postprocessor;

import org.springframework.aop.support.AopUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- with BeanCounter");
        run(BeanCounter.class);
        System.out.println("--- with EarlyBeanCounter");
        run(EarlyBeanCounter.class);
        System.out.println("--- with LazyBeanCounter");
        run(LazyBeanCounter.class);
    }

    // A context of RobotConfig (it scans Robot and LogAspect) and one of the three counters
    private static void run(Class<?> counter) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RobotConfig.class, counter);
        var robot = context.getBean(Robot.class);
        System.out.println("is a proxy:  " + AopUtils.isAopProxy(robot));
        robot.move(3);
        context.close();
    }
}
