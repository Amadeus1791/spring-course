package playground.ch2_1_aspects.ex11_postprocessor;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

// The same counter, but Ordered: Spring creates it in the same round as the post-processor
// that builds the proxies (@EnableAspectJAutoProxy), before that one is at work.
public class EarlyBeanCounter implements BeanPostProcessor, Ordered {

    private final Robot robot;
    private int count;

    public EarlyBeanCounter(Robot robot) {
        this.robot = robot;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        count++;
        return bean;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
