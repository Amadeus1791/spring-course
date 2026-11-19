package labs.lab2_1.task3_proxy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 2.1, task 3. Predict A to C first, then run. D and E: compare with the slides.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardConfig.class)) {
            CardDesk desk = context.getBean(CardDesk.class);
            System.out.println("A  desk.serve(\"Anna\")");
            desk.serve("Anna");
            System.out.println("B  desk.sign()");
            String signed = desk.sign();
            System.out.println("   returns " + signed);

            CardIssuer issuer = context.getBean(CardIssuer.class);
            System.out.println("C  issuer.issue(\"Ben\")");
            String card = issuer.issue("Ben");
            System.out.println("   returns " + card);
            System.out.println("D  the CardIssuer bean is a PlasticCardIssuer: " + (issuer instanceof PlasticCardIssuer));
            System.out.println("E  getBean(PlasticCardIssuer.class):");
            try {
                System.out.println("   " + context.getBean(PlasticCardIssuer.class).issue("Clara"));
            } catch (RuntimeException e) {
                System.out.println("   " + e.getClass().getSimpleName());
            }
        }
    }
}
