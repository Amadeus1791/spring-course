package labs.lab2_1.task2_timing;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

// Collects which methods were timed. Ready to use: the aspect calls record(...).
@Component
public class MethodTimings {

    private final List<String> timed = new ArrayList<>();

    public void record(String method, long nanos) {
        timed.add(method);
    }

    public List<String> timed() {
        return List.copyOf(timed);
    }
}
