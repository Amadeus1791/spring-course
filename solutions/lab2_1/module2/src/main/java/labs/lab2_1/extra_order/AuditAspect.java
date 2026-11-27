package labs.lab2_1.extra_order;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// Writes every payment into the audit log.
@Aspect
@Component
public class AuditAspect {

    @Around("execution(* labs.lab2_1.extra_order.CardService.pay(..))")
    public Object audit(ProceedingJoinPoint call) throws Throwable {
        System.out.println("   audit: start");
        Object result = call.proceed();
        System.out.println("   audit: end");
        return result;
    }
}
