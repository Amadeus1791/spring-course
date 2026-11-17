package playground.ch1_3_scopeslifecycle.ex5_order;

public class Station {

    public Station() {
        StationMap.STATIONS.add("Dock 7");
        System.out.println("  Station created: Dock 7 on the map");
    }
}
