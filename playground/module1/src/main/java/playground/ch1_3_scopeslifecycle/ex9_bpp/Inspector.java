package playground.ch1_3_scopeslifecycle.ex9_bpp;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

// Sees every bean after it is created. It could also return a different object.
@Component
public class Inspector implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("  inspected: " + beanName + " (" + bean.getClass().getSimpleName() + ")");
        return bean;
    }
}
