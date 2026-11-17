package playground.ch1_3_scopeslifecycle.ex5_order;

import java.util.ArrayList;
import java.util.List;

// Not a bean: a plain static list that every class can reach
public class StationMap {

    public static final List<String> STATIONS = new ArrayList<>();
}
