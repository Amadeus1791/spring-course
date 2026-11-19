package playground.ch2_1_aspects.ex11_postprocessor;

import org.springframework.stereotype.Component;

@Component
public class Robot {

    public void move(int steps) {
        System.out.println("Robot moves " + steps + " steps");
    }
}
