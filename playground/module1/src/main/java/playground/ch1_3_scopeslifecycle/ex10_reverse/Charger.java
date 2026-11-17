package playground.ch1_3_scopeslifecycle.ex10_reverse;

import org.springframework.stereotype.Component;

// A singleton: the context creates it once.
@Component
public class Charger {

    private static int created;
    private final int number;

    public Charger() {
        created++;
        number = created;
    }

    public int getNumber() {
        return number;
    }
}
