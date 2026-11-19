package playground.ch2_1_aspects.ex10b_jdkproxy;

import org.springframework.stereotype.Component;

// The same robot as before, but now it implements an interface.
@Component
public class Robot implements Movable {

    @Override
    public void move(int steps) {
        System.out.println("Robot moves " + steps + " steps");
    }
}
