package playground.ch1_2_wiringbeans.ex8_choose;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// Two batteries, two ways to choose: @Primary in one configuration, @Qualifier in the other.
// Kept apart on purpose: what wins when both meet is lab 1.2, task 2.
public class RobotConfig {

    @Configuration
    static class WithPrimary {

        @Bean
        @Primary
        public Battery lithium() {
            return new Battery("lithium");
        }

        @Bean
        public Battery alkaline() {
            return new Battery("alkaline");
        }

        @Bean
        public Robot robo(Battery battery) {
            return new Robot("Robo", battery);
        }
    }

    @Configuration
    static class WithQualifier {

        @Bean
        public Battery lithium() {
            return new Battery("lithium");
        }

        @Bean
        public Battery alkaline() {
            return new Battery("alkaline");
        }

        @Bean
        public Robot rusty(@Qualifier("alkaline") Battery battery) {
            return new Robot("Rusty", battery);
        }
    }
}
