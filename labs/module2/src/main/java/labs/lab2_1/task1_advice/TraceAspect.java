package labs.lab2_1.task1_advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// Lab 2.1, task 1. All five kinds of advice on CardPayments.pay.
@Aspect
@Component
public class TraceAspect {

    private static final String PAY = "execution(* labs.lab2_1.task1_advice.CardPayments.pay(..))";

    @Around(PAY)
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("  around: before proceed");
        Object result = joinPoint.proceed();
        System.out.println("  around: after proceed");
        return result;
    }

    @Before(PAY)
    public void before() {
        System.out.println("  before");
    }

    @After(PAY)
    public void after() {
        System.out.println("  after");
    }

    @AfterReturning(pointcut = PAY, returning = "result")
    public void afterReturning(Object result) {
        System.out.println("  afterReturning: " + result);
    }

    @AfterThrowing(pointcut = PAY, throwing = "ex")
    public void afterThrowing(Exception ex) {
        System.out.println("  afterThrowing: " + ex.getMessage());
    }
}
