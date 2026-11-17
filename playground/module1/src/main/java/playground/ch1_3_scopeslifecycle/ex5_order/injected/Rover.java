package playground.ch1_3_scopeslifecycle.ex5_order.injected;

import java.util.ArrayList;
import java.util.List;

public class Rover {

    // The rover asks for what it needs: Spring sees the dependency and creates the stations first.
    public Rover(List<Station> stations) {
        List<String> names = new ArrayList<>();
        for (Station station : stations) {
            names.add(station.getName());
        }
        System.out.println("  Rover created, stations: " + names);
    }
}
