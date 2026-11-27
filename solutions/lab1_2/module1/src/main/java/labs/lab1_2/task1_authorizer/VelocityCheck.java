package labs.lab1_2.task1_authorizer;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

// Too many payments with one card in a short time look like fraud: from the fourth one on.
@Component
public class VelocityCheck {

    private final Map<String, Integer> attempts = new HashMap<>();

    public boolean tooFast(String card) {
        int count = attempts.merge(card, 1, Integer::sum);
        return count > 3;
    }
}
