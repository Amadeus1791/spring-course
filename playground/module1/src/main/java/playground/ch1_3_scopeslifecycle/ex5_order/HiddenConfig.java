package playground.ch1_3_scopeslifecycle.ex5_order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HiddenConfig {

    @Bean
    public Rover rover() {
        return new Rover();
    }

    @Bean
    public Station station() {
        return new Station();
    }
}
