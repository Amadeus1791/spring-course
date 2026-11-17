package playground.ch1_4_propertiesprofiles.ex8_samename;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryConfig {

    @Bean
    public Robot robot() {
        return new Robot("Factory robot");
    }
}
