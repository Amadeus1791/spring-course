package playground.ch1_3_scopeslifecycle.ex11_aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

// Aware callbacks: the context tells the bean its name and itself.
@Component
public class Radio implements BeanNameAware, ApplicationContextAware {

    @Override
    public void setBeanName(String name) {
        System.out.println("  setBeanName: " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) {
        System.out.println("  setApplicationContext: " + context.getClass().getSimpleName());
    }
}
