package labs.lab1_3.task2_prototype;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Collects the steps of one authorization.
@Component
@Scope("prototype")
public class Authorization {

    private final List<String> steps = new ArrayList<>();

    public void step(String step) {
        steps.add(step);
    }

    public List<String> steps() {
        return List.copyOf(steps);
    }
}
