package labs.lab1_2.task2_whowins;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// Lab 1.2, task 2. Four configurations, each with two FraudScreen beans. Which one does the gate get?
public class Cases {

    @Configuration
    static class CaseA {
        @Bean public FraudScreen velocity() { return new FraudScreen("velocity"); }
        @Bean public FraudScreen geo() { return new FraudScreen("geo"); }

        @Bean public PaymentGate gate(FraudScreen screen) { return new PaymentGate(screen); }
    }

    @Configuration
    static class CaseB {
        @Bean public FraudScreen velocity() { return new FraudScreen("velocity"); }
        @Bean public FraudScreen geo() { return new FraudScreen("geo"); }

        @Bean public PaymentGate gate(FraudScreen geo) { return new PaymentGate(geo); }
    }

    @Configuration
    static class CaseC {
        @Bean @Primary public FraudScreen velocity() { return new FraudScreen("velocity"); }
        @Bean public FraudScreen geo() { return new FraudScreen("geo"); }

        @Bean public PaymentGate gate(FraudScreen geo) { return new PaymentGate(geo); }
    }

    @Configuration
    static class CaseD {
        @Bean @Primary public FraudScreen velocity() { return new FraudScreen("velocity"); }
        @Bean public FraudScreen geo() { return new FraudScreen("geo"); }

        @Bean public PaymentGate gate(@Qualifier("geo") FraudScreen screen) {
            return new PaymentGate(screen);
        }
    }
}
