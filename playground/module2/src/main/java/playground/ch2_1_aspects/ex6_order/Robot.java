package playground.ch2_1_aspects.ex6_order;

import org.springframework.stereotype.Component;

// A plain bean. It knows nothing about logging.
@Component
public class Robot {

    public void move(int steps) {
        System.out.println("Robot moves " + steps + " steps");
    }
}
