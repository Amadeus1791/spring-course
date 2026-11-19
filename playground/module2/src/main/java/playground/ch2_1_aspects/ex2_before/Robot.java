package playground.ch2_1_aspects.ex2_before;

import org.springframework.stereotype.Component;

@Component
public class Robot {

    public void move(int steps) {
        System.out.println("Robot moves " + steps + " steps");
    }
}
