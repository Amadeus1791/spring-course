package playground.ch1_2_wiringbeans.ex12_inject;

import jakarta.inject.Named;

@Named("lithium")                       // like @Component("lithium")
public class LithiumBattery implements Battery {
    public String type() { return "lithium"; }
}
