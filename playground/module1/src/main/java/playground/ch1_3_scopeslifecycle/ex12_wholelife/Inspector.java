package playground.ch1_3_scopeslifecycle.ex12_wholelife;

import org.springframework.beans.factory.config.BeanPostProcessor;

// A post-processor: called around the init methods of every bean. It reports only the robot.
public class Inspector implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (bean instanceof Robot) {
            Robot.log("BeanPostProcessor: before initialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (bean instanceof Robot) {
            Robot.log("BeanPostProcessor: after initialization");
        }
        return bean;
    }
}
