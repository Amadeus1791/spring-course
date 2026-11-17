package labs.lab1_3.task4_fulllite;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Lab 1.3, task 4. FullConfig and LiteConfig differ only in their first line.
@Configuration(proxyBeanMethods = false)
public class LiteConfig {

    @Bean
    public KeyStore keyStore() {
        return new KeyStore();
    }

    @Bean
    public PinPad pinPad() {
        return new PinPad(keyStore());
    }

    @Bean
    public CardReader cardReader() {
        return new CardReader(keyStore());
    }
}
