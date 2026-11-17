package playground.ch1_4_propertiesprofiles.ex5_imports;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(BatteryConfig.class)
public class RobotConfig {

    @Bean
    public Robot robot(Battery battery) {
        return new Robot(battery);
    }
}
