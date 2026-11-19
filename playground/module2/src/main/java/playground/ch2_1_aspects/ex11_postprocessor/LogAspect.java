package playground.ch2_1_aspects.ex11_postprocessor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Around("execution(* playground.ch2_1_aspects.ex11_postprocessor.Robot.move(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[log] before " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        System.out.println("[log] after " + joinPoint.getSignature().getName());
        return result;
    }
}
