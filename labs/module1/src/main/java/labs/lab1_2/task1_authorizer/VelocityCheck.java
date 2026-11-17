package labs.lab1_2.task1_authorizer;

import java.util.HashMap;
import java.util.Map;

// Too many payments with one card in a short time look like fraud: from the fourth one on.
public class VelocityCheck {

    private final Map<String, Integer> attempts = new HashMap<>();

    public boolean tooFast(String card) {
        int count = attempts.merge(card, 1, Integer::sum);
        return count > 3;
    }
}
