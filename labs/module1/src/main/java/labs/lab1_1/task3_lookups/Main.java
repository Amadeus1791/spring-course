package labs.lab1_1.task3_lookups;

import java.util.function.Supplier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 1.1, task 3. Predict A to D first, then run.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardConfig.class)) {
            lookup("A  getBean(CardNetwork.class)", () -> context.getBean(CardNetwork.class));
            lookup("B  getBean(\"cardNetwork\")", () -> context.getBean("cardNetwork"));
            lookup("C  getBean(\"visaNetwork\", LimitTable.class)",
                    () -> context.getBean("visaNetwork", LimitTable.class));
            lookup("D  getBean(FraudScreen.class)", () -> context.getBean(FraudScreen.class));
        }
    }

    // Prints the class of the bean, or the exception with its message.
    private static void lookup(String label, Supplier<Object> call) {
        System.out.println(label);
        try {
            Object bean = call.get();
            System.out.println("   a bean of class " + bean.getClass().getSimpleName());
        } catch (RuntimeException e) {
            System.out.println("   " + e.getClass().getSimpleName());
            System.out.println("   " + e.getMessage());
        }
    }
}
