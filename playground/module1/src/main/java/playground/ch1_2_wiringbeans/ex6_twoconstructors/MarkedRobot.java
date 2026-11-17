package playground.ch1_2_wiringbeans.ex6_twoconstructors;

import org.springframework.beans.factory.annotation.Autowired;

// The same two constructors, the second one marked.
public class MarkedRobot {

    private Battery battery;

    public MarkedRobot() {
        System.out.println("  MarkedRobot()");
    }

    @Autowired
    public MarkedRobot(Battery battery) {
        System.out.println("  MarkedRobot(Battery)");
        this.battery = battery;
    }

    public Battery getBattery() {
        return battery;
    }
}
