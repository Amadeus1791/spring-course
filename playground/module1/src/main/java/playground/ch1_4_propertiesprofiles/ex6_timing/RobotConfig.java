package playground.ch1_4_propertiesprofiles.ex6_timing;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:robot.properties")
public class RobotConfig {
}
