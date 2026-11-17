package playground.ch1_3_scopeslifecycle.ex7_destroy;

import jakarta.annotation.PreDestroy;

public class Battery {

    public Battery() {
        System.out.println("  Battery created");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("  Battery destroyed");
    }
}
