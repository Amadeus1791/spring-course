package playground.ch1_3_scopeslifecycle.ex5_order.injected;

public class Station {

    private final String name;

    public Station(String name) {
        this.name = name;
        System.out.println("  Station created: " + name);
    }

    public String getName() {
        return name;
    }
}
