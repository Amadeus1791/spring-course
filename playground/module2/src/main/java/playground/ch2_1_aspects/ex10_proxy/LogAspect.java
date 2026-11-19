package playground.ch2_1_aspects.ex10_proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// An aspect is a bean, too: @Aspect says what it is, @Component brings it into the context.
@Aspect
@Component
public class LogAspect {

    // Advice: runs around every call of Robot.move. The pointcut says which calls.
    @Around("execution(* playground.ch2_1_aspects.ex10_proxy.Robot.move(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[log] before " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();   // now the real method runs
        System.out.println("[log] after " + joinPoint.getSignature().getName());
        return result;
    }
}
