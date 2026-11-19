package playground.ch2_1_aspects.ex5_change;

import org.springframework.stereotype.Component;

@Component
public class Robot {

    public String move(int steps) {
        return "moved " + steps + " steps";
    }
}
