package playground.ch2_1_aspects.ex10_proxy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// Switches aspects on: Spring creates a proxy for every bean an aspect applies to.
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class RobotConfig {
}
