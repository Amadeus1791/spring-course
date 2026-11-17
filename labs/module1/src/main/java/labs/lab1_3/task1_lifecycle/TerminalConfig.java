package labs.lab1_3.task1_lifecycle;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

// Lab 1.3, task 1. Read this class and the classes it creates, then predict.
@Configuration
public class TerminalConfig {

    @Bean
    public static BeanPostProcessor terminalWatcher() {
        return new TerminalWatcher();
    }

    @Bean
    public CardNetwork network() {
        return new CardNetwork("visa");
    }

    @Bean(initMethod = "open", destroyMethod = "shutdown")
    public CardTerminal terminal() {
        return new CardTerminal();
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
