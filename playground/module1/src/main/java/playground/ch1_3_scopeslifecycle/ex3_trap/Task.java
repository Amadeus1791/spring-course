package playground.ch1_3_scopeslifecycle.ex3_trap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Task {

    private final List<String> steps = new ArrayList<>();

    public void add(String step) {
        steps.add(step);
    }

    public List<String> getSteps() {
        return steps;
    }
}
