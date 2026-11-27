package labs.lab2_1.task2_timing;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// Times every method marked @Timed. The result and an exception reach the caller unchanged.
@Aspect
@Component
public class TimingAspect {

    private final MethodTimings timings;

    public TimingAspect(MethodTimings timings) {
        this.timings = timings;
    }

    @Around("@annotation(labs.lab2_1.task2_timing.Timed)")
    public Object time(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        try {
            return joinPoint.proceed();
        } finally {
            String method = joinPoint.getSignature().getDeclaringType().getSimpleName()
                    + "." + joinPoint.getSignature().getName() + "(..)";
            timings.record(method, System.nanoTime() - start);
        }
    }
}
