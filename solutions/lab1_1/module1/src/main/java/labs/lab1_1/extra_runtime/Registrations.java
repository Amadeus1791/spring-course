package labs.lab1_1.extra_runtime;

import labs.lab1_1.extra_runtime.lib.LimitTable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Registers the beans of Main before the context starts.
public class Registrations {

    static void register(AnnotationConfigApplicationContext context) {
        context.registerBean("masker", CardNumberMasker.class);
        context.registerBean("platinumLimits", LimitTable.class, () -> LimitTable.forProduct("PLATINUM"));
    }
}
