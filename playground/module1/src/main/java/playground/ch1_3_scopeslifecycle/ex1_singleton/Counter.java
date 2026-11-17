package playground.ch1_3_scopeslifecycle.ex1_singleton;

import org.springframework.stereotype.Component;

@Component
public class Counter {

    private int count;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
