package playground.ch2_1_aspects.ex10b_jdkproxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Before("execution(* playground.ch2_1_aspects.ex10b_jdkproxy.Robot.move(..))")
    public void log(JoinPoint joinPoint) {
        System.out.println("[log] " + joinPoint.getSignature().getName());
    }
}
