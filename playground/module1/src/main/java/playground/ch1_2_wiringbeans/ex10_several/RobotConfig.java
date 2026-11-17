package playground.ch1_2_wiringbeans.ex10_several;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RobotConfig {

    @Bean
    public Battery lithium() { return new Battery("lithium"); }

    @Bean
    public Battery alkaline() { return new Battery("alkaline"); }

    @Bean
    public Dashboard dashboard(List<Battery> batteries,
                               Map<String, Battery> batteriesByName) {
        return new Dashboard(batteries, batteriesByName);
    }
}
