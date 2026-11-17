package playground.ch1_3_scopeslifecycle.ex6_callbacks;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Robot {

    public Robot() {
        System.out.println("  constructor");
    }

    @PostConstruct
    public void charge() {
        System.out.println("  @PostConstruct: charge the battery");
    }

    @PreDestroy
    public void park() {
        System.out.println("  @PreDestroy: drive back to the station");
    }
}
