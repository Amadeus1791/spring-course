package playground.ch2_1_aspects.ex7_star;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    // * as the method name, (*) as the parameters: which calls does it match?
    @Before("execution(* playground.ch2_1_aspects.ex7_star.Robot.*(*))")
    public void log(JoinPoint joinPoint) {
        System.out.println("[log] " + joinPoint.getSignature().getName());
    }
}
