package playground.ch2_1_aspects.ex9_annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    // Every method with @Logged, in whatever class.
    @Before("@annotation(playground.ch2_1_aspects.ex9_annotation.Logged)")
    public void log(JoinPoint joinPoint) {
        System.out.println("[log] " + joinPoint.getSignature().getName()
                + " called with " + Arrays.toString(joinPoint.getArgs()));
    }
}
