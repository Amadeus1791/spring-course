package labs.lab2_1.task3_proxy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
// The change: a CGLIB subclass also for beans with an interface.
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class CardConfig {
}
