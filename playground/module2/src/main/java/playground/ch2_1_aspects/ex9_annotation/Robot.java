package playground.ch2_1_aspects.ex9_annotation;

import org.springframework.stereotype.Component;

@Component
public class Robot {

    @Logged
    public void move(int steps) {
        System.out.println("Robot moves " + steps + " steps");
    }

    public void charge() {
        System.out.println("Robot charges");
    }
}
