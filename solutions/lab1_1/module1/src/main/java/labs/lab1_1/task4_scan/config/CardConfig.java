package labs.lab1_1.task4_scan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Also correct: move CardConfig up into labs.lab1_1.task4_scan and keep @ComponentScan without a package.
@Configuration
@ComponentScan("labs.lab1_1.task4_scan")
public class CardConfig {
}
