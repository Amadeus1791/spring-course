package playground.ch1_3_scopeslifecycle.ex4_eager;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class LazyRobot {

    public LazyRobot() {
        System.out.println("  LazyRobot created");
    }
}
