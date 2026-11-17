package playground.ch1_3_scopeslifecycle.ex5_order;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import playground.ch1_3_scopeslifecycle.ex5_order.injected.InjectedConfig;

public class Main {

    public static void main(String[] args) {
        System.out.println("1. OrderConfig");
        AnnotationConfigApplicationContext first = new AnnotationConfigApplicationContext(OrderConfig.class);
        first.close();

        System.out.println("2. HiddenConfig");
        AnnotationConfigApplicationContext second = new AnnotationConfigApplicationContext(HiddenConfig.class);
        second.close();

        StationMap.STATIONS.clear();
        System.out.println("3. VisibleConfig");
        AnnotationConfigApplicationContext third = new AnnotationConfigApplicationContext(VisibleConfig.class);
        third.close();

        System.out.println("4. InjectedConfig");
        var fourth = new AnnotationConfigApplicationContext(InjectedConfig.class);
        fourth.close();
    }
}
