package playground.ch1_4_propertiesprofiles.ex12_importplain;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(Clock.class)
public class RobotConfig {
}
