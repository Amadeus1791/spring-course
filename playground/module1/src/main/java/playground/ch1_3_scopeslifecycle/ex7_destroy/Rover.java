package playground.ch1_3_scopeslifecycle.ex7_destroy;

import jakarta.annotation.PreDestroy;

public class Rover {

    public Rover() {
        System.out.println("  Rover created");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("  Rover destroyed");
    }
}
