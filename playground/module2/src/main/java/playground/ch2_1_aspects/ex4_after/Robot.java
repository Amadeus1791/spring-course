package playground.ch2_1_aspects.ex4_after;

import org.springframework.stereotype.Component;

@Component
public class Robot {

    public void move(int steps) {
        if (steps < 0) {
            throw new IllegalArgumentException("negative steps: " + steps);
        }
        System.out.println("Robot moves " + steps + " steps");
    }
}
