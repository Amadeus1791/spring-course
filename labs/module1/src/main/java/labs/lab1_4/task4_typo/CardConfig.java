package labs.lab1_4.task4_typo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:lab1_4/statement.properties")
public class CardConfig {
}
