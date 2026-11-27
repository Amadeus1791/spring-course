package labs.lab1_4.extra_lists;

import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 1.4, extra task. Predict first, then run.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardConfig.class)) {
            Networks networks = context.getBean(Networks.class);
            System.out.println("A  List:  " + networks.asList() + ", size " + networks.asList().size());
            System.out.println("B  Array: " + Arrays.toString(networks.asArray()) + ", size " + networks.asArray().length);
        }
    }
}
