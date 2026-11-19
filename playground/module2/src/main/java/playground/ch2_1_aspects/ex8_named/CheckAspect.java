package playground.ch2_1_aspects.ex8_named;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CheckAspect {

    // args(percent) binds the argument to the parameter of the same name, as an int.
    @Before("RobotPointcuts.charging() && args(percent)")
    public void check(int percent) {
        System.out.println("[check] percent = " + percent);
    }
}
