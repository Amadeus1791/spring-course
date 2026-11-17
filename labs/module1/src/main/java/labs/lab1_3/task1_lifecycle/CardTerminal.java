package labs.lab1_3.task1_lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

// A card terminal in a shop. Every way to run code at birth and at death, all at once.
public class CardTerminal implements InitializingBean, DisposableBean {

    public CardTerminal() {
        System.out.println("  constructor");
    }

    @Autowired
    public void setNetwork(CardNetwork network) {
        System.out.println("  setter: network " + network.name());
    }

    @PostConstruct
    public void selfTest() {
        System.out.println("  @PostConstruct selfTest()");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("  afterPropertiesSet()");
    }

    public void open() {
        System.out.println("  initMethod open()");
    }

    @PreDestroy
    public void logOff() {
        System.out.println("  @PreDestroy logOff()");
    }

    @Override
    public void destroy() {
        System.out.println("  destroy()");
    }

    public void shutdown() {
        System.out.println("  destroyMethod shutdown()");
    }
}
