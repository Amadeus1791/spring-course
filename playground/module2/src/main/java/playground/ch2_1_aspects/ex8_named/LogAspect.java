package playground.ch2_1_aspects.ex8_named;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    // Two named pointcuts, combined: every method of Robot except charge.
    // In the same package the class name is enough, otherwise use the full name.
    @Before("RobotPointcuts.robot() && !RobotPointcuts.charging()")
    public void log(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("[log] " + name);
    }
}
