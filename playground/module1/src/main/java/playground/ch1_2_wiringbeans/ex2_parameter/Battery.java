package playground.ch1_2_wiringbeans.ex2_parameter;

public class Battery {

    private static int created;
    private final String type;

    public Battery(String type) {
        this.type = type;
        created++;
    }

    public static int created() {
        return created;
    }

    public String getType() {
        return type;
    }
}
