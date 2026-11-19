package playground.ch2_1_aspects.ex11_postprocessor;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

// The fix: the same Ordered counter, but it asks for the robot only when it needs it.
// ObjectProvider does not build the robot at start, so the robot is built later, with its proxy.
public class LazyBeanCounter implements BeanPostProcessor, Ordered {

    private final ObjectProvider<Robot> robot;
    private int count;

    public LazyBeanCounter(ObjectProvider<Robot> robot) {
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
