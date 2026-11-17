package playground.ch1_1_definingbeans.ex3_twobeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RobotConfig {

    @Bean
    public Robot robo() {
        return new Robot("Robo");
    }

    @Bean(name = "rusty")
    public Robot oldRobot() {
        return new Robot("Rusty");
    }
}
