package playground.ch1_2_wiringbeans.ex13_requiredfalse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class RobotConfig {

    // A Battery bean, but no Charger bean.
    @Configuration
    public static class WithBattery {
        @Bean
        public Battery battery() { return new Battery("lithium"); }

        @Bean
        public Robot robot() { return new Robot(); }
    }

    // Neither a Battery nor a Charger bean.
    @Configuration
    public static class NoBattery {
        @Bean
        public Robot robot() { return new Robot(); }
    }
}
