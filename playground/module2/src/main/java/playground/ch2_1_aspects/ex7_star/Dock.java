package playground.ch2_1_aspects.ex7_star;

import org.springframework.stereotype.Component;

// A second bean in the same package: does the pointcut reach it?
@Component
public class Dock {

    public void charge(int percent) {
        System.out.println("Dock charges the robot to " + percent + " %");
    }
}
