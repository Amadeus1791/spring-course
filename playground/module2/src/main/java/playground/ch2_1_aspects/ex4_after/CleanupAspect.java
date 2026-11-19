package playground.ch2_1_aspects.ex4_after;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CleanupAspect {

    // Runs after the method, however it ended: like finally. It sees neither result nor exception.
    @After("execution(* playground.ch2_1_aspects.ex4_after.Robot.move(..))")
    public void done(JoinPoint joinPoint) {
        System.out.println("[after] " + joinPoint.getSignature().getName() + " " + joinPoint.getArgs()[0]);
    }
}
