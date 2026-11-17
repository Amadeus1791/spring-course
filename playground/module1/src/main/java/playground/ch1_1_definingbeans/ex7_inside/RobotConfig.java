package playground.ch1_1_definingbeans.ex7_inside;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RobotConfig {

    @Bean
    public Robot robot() {
        System.out.println("  robot() runs");
        return new Robot("Robo");
    }
}
