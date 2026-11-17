package playground.ch1_3_scopeslifecycle.ex7_destroy;

import jakarta.annotation.PreDestroy;

public class Robot {

    private final Battery battery;

    public Robot(Battery battery) {
        this.battery = battery;
        System.out.println("  Robot created");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("  Robot destroyed");
    }
}
