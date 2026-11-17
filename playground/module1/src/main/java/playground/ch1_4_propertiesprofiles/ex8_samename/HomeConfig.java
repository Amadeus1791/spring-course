package playground.ch1_4_propertiesprofiles.ex8_samename;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HomeConfig {

    @Bean
    public Robot robot() {
        return new Robot("Home robot");
    }
}
