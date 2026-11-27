package labs.lab1_1.task2_names;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Lab 1.1, task 2. Read this class and the three classes with @Component, then predict.
@Configuration
@ComponentScan
public class CardConfig {

    @Bean
    public LimitTable limitTable() {
        return new LimitTable();
    }

    @Bean(name = {"premiumLimits", "platinumLimits"})
    public LimitTable platinumLimits() {
        return new LimitTable();
    }

    @Bean(name = {"debitLimits", "maestroLimits", "vpayLimits"})
    public LimitTable debitCardLimits() {
        return new LimitTable();
    }
}
