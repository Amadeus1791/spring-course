package playground.ch1_2_wiringbeans.ex1_methodcall;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RobotConfig {

    @Bean
    public Battery battery() {
        return new Battery("lithium");
    }

    @Bean
    public Robot robo() {
        return new Robot("Robo", battery());
    }

    @Bean
    public Robot rusty() {
        return new Robot("Rusty", battery());
    }
}
