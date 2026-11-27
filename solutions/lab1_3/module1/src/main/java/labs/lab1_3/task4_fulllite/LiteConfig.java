package labs.lab1_3.task4_fulllite;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Lab 1.3, task 4, after the change: the key store comes as a parameter, so lite mode needs no subclass.
@Configuration(proxyBeanMethods = false)
public class LiteConfig {

    @Bean
    public KeyStore keyStore() {
        return new KeyStore();
    }

    @Bean
    public PinPad pinPad(KeyStore keyStore) {
        return new PinPad(keyStore);
    }

    @Bean
    public CardReader cardReader(KeyStore keyStore) {
        return new CardReader(keyStore);
    }
}
