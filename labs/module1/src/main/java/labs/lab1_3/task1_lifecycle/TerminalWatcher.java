package labs.lab1_3.task1_lifecycle;

import org.springframework.beans.factory.config.BeanPostProcessor;

// Reports when it sees the terminal.
public class TerminalWatcher implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (beanName.equals("terminal")) {
            System.out.println("  watcher: before initialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (beanName.equals("terminal")) {
            System.out.println("  watcher: after initialization");
        }
        return bean;
    }
}
