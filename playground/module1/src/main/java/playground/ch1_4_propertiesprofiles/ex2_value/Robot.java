package playground.ch1_4_propertiesprofiles.ex2_value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Robot {

    private final String name;
    private final int speed;
    private final String color;

    public Robot(@Value("${robot.name}") String name,
                 @Value("${robot.speed}") int speed,
                 @Value("${robot.color:grey}") String color) {
        this.name = name;
        this.speed = speed;
        this.color = color;
    }

    public String describe() {
        return name + ", speed " + speed + ", color " + color;
    }
}
