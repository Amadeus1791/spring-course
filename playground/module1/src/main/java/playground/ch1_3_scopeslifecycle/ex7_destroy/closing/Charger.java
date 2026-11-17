package playground.ch1_3_scopeslifecycle.ex7_destroy.closing;

public class Charger {                      // no annotation, created by @Bean methods

    private final String name;

    public Charger(String name) {
        this.name = name;
    }

    public void close() {
        System.out.println("  Charger " + name + ": close()");
    }
}
