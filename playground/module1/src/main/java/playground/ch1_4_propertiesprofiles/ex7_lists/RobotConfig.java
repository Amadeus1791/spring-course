package playground.ch1_4_propertiesprofiles.ex7_lists;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:tools.properties")
public class RobotConfig {

    @Bean
    public Robot robot() {
        return new Robot();
    }
}
