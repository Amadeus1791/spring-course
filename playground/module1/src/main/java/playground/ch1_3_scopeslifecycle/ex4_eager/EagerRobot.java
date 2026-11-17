package playground.ch1_3_scopeslifecycle.ex4_eager;

import org.springframework.stereotype.Component;

@Component
public class EagerRobot {

    public EagerRobot() {
        System.out.println("  EagerRobot created");
    }
}
