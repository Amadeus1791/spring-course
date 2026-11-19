package labs.lab2_1.extra_order;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// Checks the caller before every payment.
// TODO Lab 2.1, extra task: the security check runs first, before the audit
@Aspect
@Component
public class SecurityAspect {

    @Around("execution(* labs.lab2_1.extra_order.CardService.pay(..))")
    public Object check(ProceedingJoinPoint call) throws Throwable {
        System.out.println("security: check");
        Object result = call.proceed();
        System.out.println("security: done");
        return result;
    }
}
