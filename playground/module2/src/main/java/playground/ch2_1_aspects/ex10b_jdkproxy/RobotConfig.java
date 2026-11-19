package playground.ch2_1_aspects.ex10b_jdkproxy;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// Plain Spring: with an interface, the proxy is built from the interface (JDK proxy).
// No @ComponentScan: Main registers Robot and LogAspect, so the two configs do not see each other.
@Configuration
@EnableAspectJAutoProxy
public class RobotConfig {
}
