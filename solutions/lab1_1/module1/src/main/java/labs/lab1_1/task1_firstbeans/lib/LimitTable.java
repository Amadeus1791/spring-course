package labs.lab1_1.task1_firstbeans.lib;

// Comes from the shared library of the core banking team: do not change this class.
public final class LimitTable {

    private final String product;
    private final int dailyLimit;

    private LimitTable(String product, int dailyLimit) {
        this.product = product;
        this.dailyLimit = dailyLimit;
    }

    public static LimitTable forProduct(String product) {
        return switch (product) {
            case "STANDARD" -> new LimitTable(product, 1000);
            case "GOLD" -> new LimitTable(product, 5000);
            default -> throw new IllegalArgumentException("Unknown card product: " + product);
        };
    }

    public String product() {
        return product;
    }

    public int dailyLimit() {
        return dailyLimit;
    }
}
