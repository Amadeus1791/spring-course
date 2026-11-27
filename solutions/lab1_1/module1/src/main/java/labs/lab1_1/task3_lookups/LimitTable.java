package labs.lab1_1.task3_lookups;

import java.util.Map;

public class LimitTable {

    private final Map<String, Integer> dailyLimits = Map.of(
            "STANDARD", 1000,
            "GOLD", 5000);

    public int dailyLimit(String product) {
        return dailyLimits.get(product);
    }
}
