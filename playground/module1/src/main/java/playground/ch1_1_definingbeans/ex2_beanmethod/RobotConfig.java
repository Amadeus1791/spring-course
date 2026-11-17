package playground.ch1_1_definingbeans.ex2_beanmethod;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RobotConfig {

    @Bean
    public Robot robot() {
        return new Robot("Robo");
    }

    @Bean
    public String greeting() {
        return "Hello";
    }

    @Bean
    public Integer answer() {
        return 42;
    }
}
