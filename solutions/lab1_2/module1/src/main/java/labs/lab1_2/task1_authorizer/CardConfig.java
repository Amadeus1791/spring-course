package labs.lab1_2.task1_authorizer;

import labs.lab1_2.task1_authorizer.lib.LimitTable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CardConfig {

    @Bean
    public LimitTable goldLimits() {
        return LimitTable.forProduct("GOLD");
    }
}
