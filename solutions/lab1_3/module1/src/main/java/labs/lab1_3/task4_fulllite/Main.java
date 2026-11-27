package labs.lab1_3.task4_fulllite;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 1.3, task 4. Predict first, then run.
public class Main {

    public static void main(String[] args) {
        run(FullConfig.class);
        run(LiteConfig.class);
    }

    private static void run(Class<?> config) {
        System.out.println(config.getSimpleName() + ":");
        try (var context = new AnnotationConfigApplicationContext(config)) {
            PinPad pinPad = context.getBean(PinPad.class);
            CardReader reader = context.getBean(CardReader.class);
            System.out.println("  same KeyStore in PinPad and CardReader: "
                    + (pinPad.keyStore() == reader.keyStore()));
            System.out.println("  class of the configuration bean: "
                    + context.getBean(config).getClass().getSimpleName());
        }
    }
}
