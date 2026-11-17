package playground.ch1_3_scopeslifecycle.ex5_order;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
    }
}
