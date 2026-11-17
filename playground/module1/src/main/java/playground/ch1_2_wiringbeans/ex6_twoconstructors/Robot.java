package playground.ch1_2_wiringbeans.ex6_twoconstructors;

import org.springframework.stereotype.Component;

// Two constructors, neither marked with @Autowired.
@Component
public class Robot {

    private Battery battery;

    public Robot() {
        System.out.println("  Robot()");
    }

    public Robot(Battery battery) {
        System.out.println("  Robot(Battery)");
        this.battery = battery;
    }

    public Battery getBattery() {
        return battery;
    }
}
