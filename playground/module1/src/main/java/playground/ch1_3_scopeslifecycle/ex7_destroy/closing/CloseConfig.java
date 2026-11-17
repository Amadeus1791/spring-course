package playground.ch1_3_scopeslifecycle.ex7_destroy.closing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CloseConfig {

    @Bean
    public Charger charger() {
        return new Charger("A");
    }

    @Bean(destroyMethod = "")
    public Charger spareCharger() {
        return new Charger("B");
    }
}
