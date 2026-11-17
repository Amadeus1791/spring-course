package playground.ch1_3_scopeslifecycle.ex7_destroy.closing;

import org.springframework.stereotype.Component;

@Component
public class Lamp {                         // a component with a close() method

    public void close() {
        System.out.println("  Lamp: close()");
    }
}
