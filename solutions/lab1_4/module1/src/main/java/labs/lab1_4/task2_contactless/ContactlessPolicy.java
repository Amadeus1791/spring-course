package labs.lab1_4.task2_contactless;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// The rules for paying without a PIN.
@Component
public class ContactlessPolicy {

    private final int limit;
    private final int pinEvery;
    private final String currency;
    private final int limitInCents;

    public ContactlessPolicy(@Value("${card.contactless.limit}") int limit,
                             @Value("${card.contactless.pin-every}") int pinEvery,
                             @Value("${card.currency:EUR}") String currency,
                             @Value("#{${card.contactless.limit} * 100}") int limitInCents) {
        this.limit = limit;
        this.pinEvery = pinEvery;
        this.currency = currency;
        this.limitInCents = limitInCents;
    }

    public String describe() {
        return "Contactless up to " + limit + " " + currency + " (" + limitInCents + " cents), "
                + "PIN every " + pinEvery + ". payment";
    }
}
