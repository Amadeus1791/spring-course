package playground.ch1_1_definingbeans.ex8_lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RobotConfig {

    @Bean
    public Robot robot() {
        return new Robot("Robo");
    }
}
