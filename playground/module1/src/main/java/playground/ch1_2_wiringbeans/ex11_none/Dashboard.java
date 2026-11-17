package playground.ch1_2_wiringbeans.ex11_none;

import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;

public record Dashboard(Optional<Battery> battery, ObjectProvider<Battery> batteries) {
}
