package playground.ch2_1_aspects.ex10b_jdkproxy;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// The same, but CGLIB is forced: the proxy is a subclass of Robot again.
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ClassProxyConfig {
}
