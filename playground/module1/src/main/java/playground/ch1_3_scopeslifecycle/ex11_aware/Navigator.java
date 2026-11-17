package playground.ch1_3_scopeslifecycle.ex11_aware;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

// Usually simpler: ask for the context like any other dependency.
@Component
public class Navigator {

    private final ApplicationContext context;

    public Navigator(ApplicationContext context) {
        this.context = context;
    }

    public ApplicationContext getContext() {
        return context;
    }
}
