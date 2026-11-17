package playground.ch1_2_wiringbeans.ex10_several;

import java.util.List;
import java.util.Map;

// Asks for all Battery beans: as a list, and as a map from bean name to bean.
public record Dashboard(List<Battery> batteries, Map<String, Battery> batteriesByName) {
}
