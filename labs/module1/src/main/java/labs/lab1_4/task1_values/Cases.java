package labs.lab1_4.task1_values;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// Lab 1.4, task 1. Four configurations read lab1_4/values.properties. What does each value become?
public class Cases {

    // Main starts this case with the system property -Dcard.region=US.
    @Configuration
    @PropertySource("classpath:lab1_4/values.properties")
    static class CaseA {
        @Bean public Setting setting(@Value("${card.region}") String value) { return new Setting(value); }
    }

    @Configuration
    @PropertySource("classpath:lab1_4/values.properties")
    static class CaseB {
        @Bean public Setting setting(@Value("${card.network}") String value) { return new Setting(value); }
    }

    @Configuration
    @PropertySource("classpath:lab1_4/values.properties")
    static class CaseC {
        @Bean public Setting setting(@Value("${card.limit}") int value) { return new Setting(value); }
    }

    @Configuration
    @PropertySource("classpath:lab1_4/values.properties")
    static class CaseD {
        @Bean public Setting setting(@Value("#{card.region}") String value) { return new Setting(value); }
    }
}
