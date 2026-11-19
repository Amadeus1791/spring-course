package playground.ch2_1_aspects.ex6_order;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// The lower number has the higher priority: it runs first before the call, last after it.
@Aspect
@Component
@Order(1)
public class OuterAspect {

    @Around("execution(* playground.ch2_1_aspects.ex6_order.Robot.move(..))")
    public Object wrap(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[outer] before");
        Object result = joinPoint.proceed();
        System.out.println("[outer] after");
        return result;
    }
}
