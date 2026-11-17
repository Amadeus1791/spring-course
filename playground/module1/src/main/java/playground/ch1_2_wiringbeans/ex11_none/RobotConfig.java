package playground.ch1_2_wiringbeans.ex11_none;

import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class RobotConfig {

    // No Battery bean anywhere. Three parameters that accept "none".
    @Configuration
    public static class Tolerant {
        @Bean
        public Dashboard dashboard(
                Optional<Battery> battery,
                ObjectProvider<Battery> batteries) {
            return new Dashboard(battery, batteries);
        }

        @Bean
        public Panel panel() { return new Panel(); }
    }

    // A plain Battery parameter: the start fails.
    // no Battery bean anywhere
    @Configuration
    public static class Strict {
        @Bean
        public Robot robot(Battery battery) {
            return new Robot(battery);
        }
    }
}
