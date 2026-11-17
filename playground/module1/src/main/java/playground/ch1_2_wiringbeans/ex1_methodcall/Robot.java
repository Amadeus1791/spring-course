package playground.ch1_2_wiringbeans.ex1_methodcall;

public class Robot {

    private final String name;
    private final Battery battery;

    public Robot(String name, Battery battery) {
        this.name = name;
        this.battery = battery;
    }

    public String getName() {
        return name;
    }

    public Battery getBattery() {
        return battery;
    }
}
