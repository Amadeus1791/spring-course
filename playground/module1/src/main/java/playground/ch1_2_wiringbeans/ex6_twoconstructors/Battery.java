package playground.ch1_2_wiringbeans.ex6_twoconstructors;

import org.springframework.stereotype.Component;

@Component
public class Battery {

    public String getType() {
        return "lithium";
    }
}
