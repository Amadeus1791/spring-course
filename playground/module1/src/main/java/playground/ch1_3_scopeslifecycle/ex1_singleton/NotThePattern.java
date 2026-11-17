package playground.ch1_3_scopeslifecycle.ex1_singleton;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import playground.ch1_3_scopeslifecycle.ex1b_twocounters.TwoCounters;

public class NotThePattern {

    public static void main(String[] args) {
        var one = new AnnotationConfigApplicationContext(RobotConfig.class);
        var two = new AnnotationConfigApplicationContext(RobotConfig.class);
        Counter fromOne = one.getBean(Counter.class);
        Counter fromTwo = two.getBean(Counter.class);
        System.out.println("Two contexts, one counter:  " + (fromOne == fromTwo));

        var three = new AnnotationConfigApplicationContext(TwoCounters.class);
        System.out.println("Counter beans in a context: " + three.getBeansOfType(Counter.class).keySet());

        one.close();
        two.close();
        three.close();
    }
}
