package playground.ch2_1_aspects.ex3_returning;

import org.springframework.stereotype.Component;

@Component
public class Robot {

    public String move(int steps) {
        if (steps < 0) {
            throw new IllegalArgumentException("negative steps: " + steps);
        }
        return "moved " + steps + " steps";
    }
}
