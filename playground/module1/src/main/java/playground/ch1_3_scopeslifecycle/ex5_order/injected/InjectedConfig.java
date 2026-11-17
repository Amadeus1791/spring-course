package playground.ch1_3_scopeslifecycle.ex5_order.injected;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InjectedConfig {

    @Bean
    public Rover rover(List<Station> stations) {
        return new Rover(stations);
    }

    @Bean
    public Station dock7() {
        return new Station("Dock 7");
    }
}
