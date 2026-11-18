package playground.ch1_2_wiringbeans.ex13_requiredfalse;

import org.springframework.beans.factory.annotation.Autowired;

public class Robot {

    private Battery battery = new Battery("spare");     // a default of its own
    private String parts = "none";

    @Autowired(required = false)
    public void setBattery(Battery battery) {
        System.out.println("  setBattery called");
        this.battery = battery;
    }

    @Autowired(required = false)
    public void setParts(Battery b, Charger c) {
        System.out.println("  setParts called");
        this.parts = "battery and charger";
    }

    public String describe() {
        return "battery: " + battery.type() + ", parts: " + parts;
    }
}
