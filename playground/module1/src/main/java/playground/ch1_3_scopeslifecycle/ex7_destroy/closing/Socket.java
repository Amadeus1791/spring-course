package playground.ch1_3_scopeslifecycle.ex7_destroy.closing;

import org.springframework.stereotype.Component;

@Component
public class Socket implements AutoCloseable {   // a component that is AutoCloseable

    @Override
    public void close() {
        System.out.println("  Socket: close()");
    }
}
