package playground.ch1_4_propertiesprofiles.ex6_timing;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("home")
public class HomeRobot {
}
