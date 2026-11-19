package playground.ch2_1_aspects.ex5_change;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// Changes what goes in and what comes out. Robot does not notice.
@Aspect
@Component
public class SafetyAspect {

    @Around("execution(* playground.ch2_1_aspects.ex5_change.Robot.move(..))")
    public Object limit(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        int steps = (int) args[0];
        if (steps > 10) {
            args[0] = 10;                          // at most 10 steps
        }
        Object result = joinPoint.proceed(args);   // the method gets the changed arguments
        return result + " (checked)";              // the caller gets a changed result
    }
}
