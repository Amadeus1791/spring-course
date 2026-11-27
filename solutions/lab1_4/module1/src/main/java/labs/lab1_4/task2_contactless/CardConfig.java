package labs.lab1_4.task2_contactless;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:lab1_4/contactless.properties")
public class CardConfig {
}
