package labs.lab1_1.task3_lookups;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Lab 1.1, task 3. Read this class and the classes next to it, then predict.
@Configuration
@ComponentScan
public class CardConfig {

    @Bean
    public LimitTable limits() {
        return new LimitTable();
    }
}
