package labs.lab1_1.extra_runtime;

import java.util.ArrayList;
import java.util.List;
import labs.lab1_1.extra_runtime.lib.LimitTable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 1.1, extra task. A context without a configuration class. Do not change this class.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext()) {
            Registrations.register(context);
            context.refresh();

            CardNumberMasker masker = context.getBean("masker", CardNumberMasker.class);
            LimitTable platinum = context.getBean("platinumLimits", LimitTable.class);

            System.out.println("Card:     " + masker.mask("4242424242424242"));
            System.out.println("Platinum: " + platinum.dailyLimit() + " EUR a day");
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
