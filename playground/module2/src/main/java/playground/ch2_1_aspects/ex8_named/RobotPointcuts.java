package playground.ch2_1_aspects.ex8_named;

import org.aspectj.lang.annotation.Pointcut;

// Named pointcuts: a method with an empty body, the expression sits on @Pointcut.
// Every aspect can use them by name. The class needs no @Aspect and no @Component.
public class RobotPointcuts {

    @Pointcut("within(playground.ch2_1_aspects.ex8_named.Robot)")
    public void robot() {}
    @Pointcut("execution(* charge(..))")
    public void charging() {}
}
