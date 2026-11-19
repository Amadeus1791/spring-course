package playground.ch1_3_scopeslifecycle.ex12_wholelife;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

// Every life-cycle method at once. Each one prints its step: the numbers come from the run.
public class Robot implements BeanNameAware, InitializingBean, DisposableBean {

    private static int step;

    static void log(String what) {
        step++;
        System.out.println(step + ". " + what);
    }

    public Robot() {
        log("constructor");
    }

    @Autowired
    public void setBattery(Battery battery) {
        log("setter: setBattery");
    }

    @Override
    public void setBeanName(String name) {
        log("BeanNameAware: setBeanName(" + name + ")");
    }

    @PostConstruct
    public void postConstruct() {
        log("@PostConstruct");
    }

    @Override
    public void afterPropertiesSet() {
        log("InitializingBean: afterPropertiesSet()");
    }

    public void open() {
        log("initMethod: open()");
    }

    public void work() {
        System.out.println("   ... the robot works");
    }

    @PreDestroy
    public void preDestroy() {
        log("@PreDestroy");
    }

    @Override
    public void destroy() {
        log("DisposableBean: destroy()");
    }

    public void seal() {
        log("destroyMethod: seal()");
    }
}
