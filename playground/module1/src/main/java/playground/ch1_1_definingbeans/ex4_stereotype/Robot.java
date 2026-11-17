package playground.ch1_1_definingbeans.ex4_stereotype;

import org.springframework.stereotype.Component;

@Component
public class Robot {

    private String name = "nameless";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
