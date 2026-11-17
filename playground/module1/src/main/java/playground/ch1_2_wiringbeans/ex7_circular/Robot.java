package playground.ch1_2_wiringbeans.ex7_circular;

import org.springframework.stereotype.Component;

@Component
public class Robot {

    private final Charger charger;

    public Robot(Charger charger) {
        this.charger = charger;
    }
}
