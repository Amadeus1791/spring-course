package labs.lab1_3.task1_lifecycle;

import jakarta.annotation.PreDestroy;

// The keys the terminal needs to check a PIN.
public class PinKeys {

    public PinKeys() {
        System.out.println("  keys loaded");
    }

    @PreDestroy
    public void wipe() {
        System.out.println("  keys wiped");
    }
}
