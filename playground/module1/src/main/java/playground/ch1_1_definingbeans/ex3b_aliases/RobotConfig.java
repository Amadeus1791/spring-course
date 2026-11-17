package playground.ch1_1_definingbeans.ex3b_aliases;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RobotConfig {

    // One bean, three names.
    @Bean(name = {"robo", "robbie", "r2"})
    public Robot robot() {
        return new Robot("Robo");
    }
}
