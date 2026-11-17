package playground.ch1_3_scopeslifecycle.ex5_order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
