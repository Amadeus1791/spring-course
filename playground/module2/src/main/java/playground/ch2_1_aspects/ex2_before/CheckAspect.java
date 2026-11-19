package playground.ch2_1_aspects.ex2_before;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CheckAspect {

    // Runs before the method. It cannot skip the call, it can only stop it by throwing.
    @Before("execution(* playground.ch2_1_aspects.ex2_before.Robot.move(..))")
    public void check(JoinPoint joinPoint) {
        int steps = (int) joinPoint.getArgs()[0];
        System.out.println("[check] " + steps + " steps");
        if (steps > 10) {
            throw new IllegalArgumentException("too many steps: " + steps);
        }
    }
}
