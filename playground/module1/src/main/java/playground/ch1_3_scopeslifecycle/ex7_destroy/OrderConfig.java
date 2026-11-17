package playground.ch1_3_scopeslifecycle.ex7_destroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class OrderConfig {

    @Bean
    public Robot robot(Battery battery) {
        return new Robot(battery);
    }

    @Bean
    public Garage garage() {
        return new Garage();
    }

    @Bean
    public Battery battery() {
        return new Battery();
    }

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
