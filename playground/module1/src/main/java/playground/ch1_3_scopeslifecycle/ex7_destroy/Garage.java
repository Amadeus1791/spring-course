package playground.ch1_3_scopeslifecycle.ex7_destroy;

import jakarta.annotation.PreDestroy;

public class Garage {

    public Garage() {
        System.out.println("  Garage created");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("  Garage destroyed");
    }
}
