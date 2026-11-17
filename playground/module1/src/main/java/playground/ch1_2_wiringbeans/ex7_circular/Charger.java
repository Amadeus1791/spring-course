package playground.ch1_2_wiringbeans.ex7_circular;

import org.springframework.stereotype.Component;

@Component
public class Charger {

    private final Robot robot;

    public Charger(Robot robot) {
        this.robot = robot;
    }
}
