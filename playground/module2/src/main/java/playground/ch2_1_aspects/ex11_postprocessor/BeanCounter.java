package playground.ch2_1_aspects.ex11_postprocessor;

import org.springframework.beans.factory.config.BeanPostProcessor;

// A post-processor of our own that counts the beans. It also wants the robot.
// No @Component: Main registers it next to RobotConfig.
public class BeanCounter implements BeanPostProcessor {

    private final Robot robot;
    private int count;

    public BeanCounter(Robot robot) {
        this.robot = robot;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        count++;
        return bean;
    }
}
