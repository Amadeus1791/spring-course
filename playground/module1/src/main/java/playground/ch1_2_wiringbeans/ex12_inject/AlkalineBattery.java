package playground.ch1_2_wiringbeans.ex12_inject;

import jakarta.inject.Named;

@Named("alkaline")                      // like @Component("alkaline")
public class AlkalineBattery implements Battery {
    public String type() { return "alkaline"; }
}
