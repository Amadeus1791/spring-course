package playground.ch1_3_scopeslifecycle.ex1b_twocounters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import playground.ch1_3_scopeslifecycle.ex1_singleton.Counter;

@Configuration
public class TwoCounters {

    @Bean
    public Counter visits() {
        return new Counter();
    }

    @Bean
    public Counter clicks() {
        return new Counter();
    }
}
