package playground.ch1_3_scopeslifecycle.ex7_destroy;

import jakarta.annotation.PreDestroy;

public class Station {

    public Station() {
        System.out.println("  Station created");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("  Station destroyed");
    }
}
