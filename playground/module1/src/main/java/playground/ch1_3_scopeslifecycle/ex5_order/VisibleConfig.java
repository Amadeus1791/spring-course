package playground.ch1_3_scopeslifecycle.ex5_order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class VisibleConfig {

    @Bean
    @DependsOn("station")
    public Rover rover() {
        return new Rover();
    }

    @Bean
    public Station station() {
        return new Station();
    }
}
