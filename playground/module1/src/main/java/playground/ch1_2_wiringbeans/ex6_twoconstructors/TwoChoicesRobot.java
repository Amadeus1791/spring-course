package playground.ch1_2_wiringbeans.ex6_twoconstructors;

// Two constructors with parameters, none without, none marked.
public class TwoChoicesRobot {

    public TwoChoicesRobot(Battery battery) {
        System.out.println("  TwoChoicesRobot(Battery)");
    }

    public TwoChoicesRobot(Battery battery, Charger charger) {
        System.out.println("  TwoChoicesRobot(Battery, Charger)");
    }
}
