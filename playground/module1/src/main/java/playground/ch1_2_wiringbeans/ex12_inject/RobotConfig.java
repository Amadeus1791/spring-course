package playground.ch1_2_wiringbeans.ex12_inject;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan                          // finds @Named classes like @Component classes
public class RobotConfig {
}
