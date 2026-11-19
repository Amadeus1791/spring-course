package labs.lab1_3.task1_lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

// Lab 1.3, task 1. Read this class and the classes it creates, then predict.
// The terminal is declared before its keys on purpose.
@Configuration
public class TerminalConfig {

    @Bean
    public CardTerminal terminal(PinKeys keys) {
        return new CardTerminal(keys);
    }

    @Bean
    public PinKeys keys() {
        return new PinKeys();
    }

    @Bean
    @Scope("prototype")
    public Receipt receipt() {
        return new Receipt();
    }

    @Bean
    @Lazy
    public DailyArchive archive() {
        return new DailyArchive();
    }
}
