package playground.ch1_2_wiringbeans.ex2_parameter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RobotConfig {

    @Bean
    public Robot robo(Battery battery) {
        return new Robot("Robo", battery);
    }
}
