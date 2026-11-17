package playground.ch1_2_wiringbeans.ex5_constructor;

import org.springframework.stereotype.Component;

@Component
public class Robot {

    private final Battery battery;

    // One constructor: Spring uses it, @Autowired is optional.
    public Robot(Battery battery) {
        this.battery = battery;
    }

    public Battery getBattery() {
        return battery;
    }
}
