package playground.ch1_3_scopeslifecycle.ex3_trap;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Component
public class FixedRobot {

    private final ObjectProvider<Task> tasks;

    public FixedRobot(ObjectProvider<Task> tasks) {
        this.tasks = tasks;
    }

    public Task newTask() {
        return tasks.getObject();   // asks the context every time
    }
}
