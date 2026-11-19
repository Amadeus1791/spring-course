package playground.ch2_1_aspects.ex7_star;

import org.springframework.stereotype.Component;

@Component
public class Robot {

    public void move(int steps) {
        System.out.println("Robot moves " + steps + " steps");
    }

    public void turn(String direction) {
        System.out.println("Robot turns " + direction);
    }

    public void stop() {
        System.out.println("Robot stops");
    }
}
