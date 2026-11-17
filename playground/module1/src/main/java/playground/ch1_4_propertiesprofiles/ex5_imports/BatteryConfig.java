package playground.ch1_4_propertiesprofiles.ex5_imports;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatteryConfig {

    @Bean
    public Battery battery() {
        return new Battery();
    }
}
