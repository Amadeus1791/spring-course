package labs.lab1_1.task1_firstbeans;

import labs.lab1_1.task1_firstbeans.lib.LimitTable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// CardNumberMasker: own class, so @Component and the scan.
// LimitTable: a library class without a public constructor, needed twice: two @Bean methods.
@Configuration
@ComponentScan
public class CardConfig {

    @Bean
    public LimitTable standardLimits() {
        return LimitTable.forProduct("STANDARD");
    }

    @Bean
    public LimitTable goldLimits() {
        return LimitTable.forProduct("GOLD");
    }
}
