package playground.ch1_3_scopeslifecycle.ex12_wholelife;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RobotConfig {

    @Bean
    public Battery battery() {
        return new Battery();
    }

    @Bean(initMethod = "open", destroyMethod = "seal")
    public Robot robot() {
        return new Robot();
    }

    // static: a post-processor must exist before the other beans (chapter 1.3, under the hood)
    @Bean
    public static Inspector inspector() {
        return new Inspector();
    }
}
