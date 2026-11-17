package playground.ch1_2_wiringbeans.ex3_field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Robot {

    @Autowired
    private Battery battery;

    public Battery getBattery() {
        return battery;
    }
}
