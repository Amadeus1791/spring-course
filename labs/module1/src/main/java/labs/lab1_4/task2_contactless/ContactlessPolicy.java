package labs.lab1_4.task2_contactless;

// The rules for paying without a PIN.
// TODO Lab 1.4, task 2: the four values from the file, a default and an expression
public class ContactlessPolicy {

    private final int limit;
    private final int pinEvery;
    private final String currency;
    private final int limitInCents;

    public ContactlessPolicy(int limit, int pinEvery, String currency, int limitInCents) {
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
