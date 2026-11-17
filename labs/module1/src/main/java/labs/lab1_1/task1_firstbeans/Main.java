package labs.lab1_1.task1_firstbeans;

import java.util.ArrayList;
import java.util.List;
import labs.lab1_1.task1_firstbeans.lib.LimitTable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 1.1, task 1. Do not change this class.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardConfig.class)) {
            CardNumberMasker masker = context.getBean(CardNumberMasker.class);
            LimitTable standard = context.getBean("standardLimits", LimitTable.class);
            LimitTable gold = context.getBean("goldLimits", LimitTable.class);

            System.out.println("Card:     " + masker.mask("4242424242424242"));
            System.out.println("Standard: " + standard.dailyLimit() + " EUR a day");
            System.out.println("Gold:     " + gold.dailyLimit() + " EUR a day");
            System.out.println("Beans:    " + ownBeanNames(context));
        }
    }

    // All bean names except the ones Spring registers for itself.
    private static List<String> ownBeanNames(AnnotationConfigApplicationContext context) {
        List<String> names = new ArrayList<>();
        for (String name : context.getBeanDefinitionNames()) {
            if (!name.startsWith("org.springframework")) {
                names.add(name);
            }
        }
        return names;
    }
}
