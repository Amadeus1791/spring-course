package playground.ch1_1_definingbeans.ex5_scan.garage;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan          // no package given
public class GarageConfig {
}
