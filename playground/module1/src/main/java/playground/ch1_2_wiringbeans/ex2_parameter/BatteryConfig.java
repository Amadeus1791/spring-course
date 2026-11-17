package playground.ch1_2_wiringbeans.ex2_parameter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Another configuration class. A parameter finds beans everywhere in the container.
@Configuration
public class BatteryConfig {

    @Bean
    public Battery battery() {
        return new Battery("lithium");
    }
}
