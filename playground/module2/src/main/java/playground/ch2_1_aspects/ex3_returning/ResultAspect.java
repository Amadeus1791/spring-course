package playground.ch2_1_aspects.ex3_returning;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ResultAspect {

    // Only after a normal return. "returning" names the parameter that gets the result.
    @AfterReturning(pointcut = "execution(* playground.ch2_1_aspects.ex3_returning.Robot.move(..))",
            returning = "result")
    public void ok(Object result) {
        System.out.println("[ok] " + result);
    }

    // Only after an exception. "throwing" names the parameter that gets the exception.
    @AfterThrowing(pointcut = "execution(* playground.ch2_1_aspects.ex3_returning.Robot.move(..))",
            throwing = "ex")
    public void failed(IllegalArgumentException ex) {
        System.out.println("[failed] " + ex.getMessage());
    }
}
