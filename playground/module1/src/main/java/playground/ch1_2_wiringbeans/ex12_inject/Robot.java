package playground.ch1_2_wiringbeans.ex12_inject;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named                                  // like @Component: bean name "robot"
public class Robot {

    private final Battery battery;

    @Inject                             // like @Autowired, without a required attribute
    public Robot(@Named("alkaline") Battery battery) {   // like @Qualifier("alkaline")
        this.battery = battery;
    }

    public Battery battery() { return battery; }
}
