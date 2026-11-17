package playground.ch1_4_propertiesprofiles.ex3_spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Robot {

    @Value("#{60 * 60 * 8}")                            // arithmetic
    private int secondsPerShift;

    @Value("#{'${robot.name}'.toUpperCase()}")          // a placeholder inside an expression
    private String loudName;

    @Value("#{battery.capacity / 2}")                   // another bean, by its name
    private int reserve;

    @Value("#{systemProperties['robot.mode'] ?: 'normal'}")   // Elvis: default if null
    private String mode;

    public String describe() {
        return "seconds per shift: " + secondsPerShift + "\n"
                + "loud name:         " + loudName + "\n"
                + "reserve:           " + reserve + "\n"
                + "mode:              " + mode;
    }
}
