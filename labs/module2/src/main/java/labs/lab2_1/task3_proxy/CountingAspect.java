package labs.lab2_1.task3_proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// Prints every call of a method of CardDesk or PlasticCardIssuer that it sees.
@Aspect
@Component
public class CountingAspect {

    @Before("execution(* labs.lab2_1.task3_proxy.CardDesk.*(..)) || execution(* labs.lab2_1.task3_proxy.PlasticCardIssuer.*(..))")
    public void seen(JoinPoint joinPoint) {
        System.out.println("   aspect sees " + joinPoint.getSignature().getName() + "()");
    }
}
