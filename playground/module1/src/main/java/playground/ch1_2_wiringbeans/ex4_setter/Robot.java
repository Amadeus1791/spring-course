package playground.ch1_2_wiringbeans.ex4_setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Robot {

    private Battery battery;

    @Autowired
    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public Battery getBattery() {
        return battery;
    }
}
