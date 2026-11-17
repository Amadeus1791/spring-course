package playground.ch1_3_scopeslifecycle.ex3_trap;

import org.springframework.stereotype.Component;

@Component
public class Robot {

    private final Task task;

    public Robot(Task task) {
        this.task = task;
    }

    public Task newTask() {
        return task;     // the robot was created once, so it was handed one task, once
    }
}
