package playground.ch1_4_propertiesprofiles.ex1_source;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:robot.properties")
public class RobotConfig {
}
