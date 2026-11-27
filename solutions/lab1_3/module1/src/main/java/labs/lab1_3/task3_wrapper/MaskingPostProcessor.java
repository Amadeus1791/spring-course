package labs.lab1_3.task3_wrapper;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

// Wraps every CardNotifier bean. The context keeps what this method returns: the wrapper.
@Component
public class MaskingPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (bean instanceof CardNotifier notifier) {
            return new MaskingNotifier(notifier);
        }
        return bean;
    }
}
