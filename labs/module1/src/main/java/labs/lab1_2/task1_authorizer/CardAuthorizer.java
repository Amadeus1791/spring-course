package labs.lab1_2.task1_authorizer;

import labs.lab1_2.task1_authorizer.lib.LimitTable;

// Decides whether a card payment goes through.
public class CardAuthorizer {

    private final LimitTable limits;
    private final VelocityCheck velocity;

    // The reporting tool replays old payments with this constructor: no checks at all. Keep it.
    public CardAuthorizer() {
        this.limits = null;
        this.velocity = null;
    }

    public CardAuthorizer(LimitTable limits, VelocityCheck velocity) {
        this.limits = limits;
        this.velocity = velocity;
    }

    public String authorize(String card, int amount) {
        if (velocity != null && velocity.tooFast(card)) {
            return "DECLINED (velocity)";
        }
        if (limits != null && amount > limits.dailyLimit()) {
            return "DECLINED (limit " + limits.dailyLimit() + ")";
        }
        return "APPROVED";
    }
}
