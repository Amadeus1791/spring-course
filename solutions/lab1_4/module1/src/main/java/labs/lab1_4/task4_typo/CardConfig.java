package labs.lab1_4.task4_typo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan
@PropertySource("classpath:lab1_4/statement.properties")
public class CardConfig {

    // Strict placeholders: a key that no source knows stops the start.
    // static, because it is a BeanFactoryPostProcessor (chapter 1.3).
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholders() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
