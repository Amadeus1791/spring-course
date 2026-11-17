package playground.ch1_2_wiringbeans.ex4_setter;

import org.springframework.stereotype.Component;

@Component
public class Battery {

    public String getType() {
        return "lithium";
    }
}
