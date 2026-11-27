package labs.lab1_3.task1_lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

// A card terminal in a shop. It cannot work without its PIN keys.
public class CardTerminal {

    private final PinKeys keys;

    public CardTerminal(PinKeys keys) {
        this.keys = keys;
        System.out.println("  terminal created");
    }

    @PostConstruct
    public void selfTest() {
        System.out.println("  terminal ready");
    }

    @PreDestroy
    public void switchOff() {
        System.out.println("  terminal off");
    }
}
