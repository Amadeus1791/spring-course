package playground.ch1_3_scopeslifecycle.ex10_reverse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// A prototype that needs a singleton.
@Component
@Scope("prototype")
public class Drone {

    private static int created;
    private final int number;
    private final Charger charger;

    public Drone(Charger charger) {
        created++;
        this.number = created;
        this.charger = charger;
    }

    public String describe() {
        return "drone " + number + " uses charger " + charger.getNumber();
    }
}
